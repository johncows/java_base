package org.cheapter10;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Optional;

public class SimpleThreadPool extends Thread {


    private int size;

    private int taskSize;

    private static final int DEFAULT_SIZE = 10;

    private boolean threadStatus = true;

    private static volatile int seq = 0;

    private final static LinkedList<Runnable> TASK_QUEUE = new LinkedList();

    private final static String THREAD_PREFIX = "SIMPLE_THREAD_POOL_";

    private final static ThreadGroup GROUP = new ThreadGroup("Pool_GROUP");

    private final static int DEFAULT_QUEUE_SIZE = 40;

    private final static ArrayList<WorkerTask> THREAD_QUEUE = new ArrayList();

    private final DiscardPolicy DISCARD_POLICY;


    public SimpleThreadPool() {
        this(DEFAULT_SIZE, DEFAULT_QUEUE_SIZE, () -> {
            throw new DiscardPolicyException("当前任务队列已满，拒绝执行该任务计划，请稍后重试");
        });
    }

    @Override
    public void run() {

    }

    public SimpleThreadPool(int initSize, int initQueueSize, DiscardPolicy discardPolicy) {
        this.size = initSize;
        this.taskSize = initQueueSize;
        this.DISCARD_POLICY = discardPolicy;
        init();
    }


    public void submitTask(Runnable task) {
        if (!threadStatus) {
            throw new RuntimeException("该线程池已关闭，no server");
        }
        if (TASK_QUEUE.size() > taskSize) {
            DISCARD_POLICY.discard();
            return;
        }
        synchronized (TASK_QUEUE) {
            TASK_QUEUE.addLast(task);
            TASK_QUEUE.notifyAll();
        }
    }

    public void shutdown() throws InterruptedException {
        // 不接客了
        this.threadStatus = false;
        while (!TASK_QUEUE.isEmpty()) {
            Thread.sleep(1_000);
        }
        TASK_QUEUE.clear();

        while (true) {
            THREAD_QUEUE.stream().filter(e -> e.taskState == TaskState.BLOCKED).forEach(e -> {
                e.close();
                e.interrupt();
                size--;
            });
            if (size <= 0) {
                break;
            }
            Thread.sleep(2_000);
        }
    }

    public static class DiscardPolicyException extends RuntimeException {
        public DiscardPolicyException(String message) {
            super(message);
        }
    }

    public interface DiscardPolicy {
        void discard() throws DiscardPolicyException;
    }


    private void init() {
        for (int i = 0; i < this.size; i++) {
            createWorkerTask();
        }
    }

    private void createWorkerTask() {
        WorkerTask workerTask = new WorkerTask(GROUP, THREAD_PREFIX + seq++);
        workerTask.start();
        THREAD_QUEUE.add(workerTask);
    }


    private enum TaskState {
        FREE, RUNNING, BLOCKED, DEAD
    }

    private static class WorkerTask extends Thread {

        private volatile TaskState taskState = TaskState.FREE;


        @Override
        public void run() {
            Runnable task;
            Outer:
            while (this.taskState != TaskState.DEAD) {

                /**
                 *  这段加锁
                 *   第一 存在对共享变量的读写 即TaskQueue写操作
                 *   第二 需要阻塞该run方法
                 */
                synchronized (TASK_QUEUE) {
                    while (TASK_QUEUE.isEmpty()) {
                        try {
                            this.taskState = TaskState.BLOCKED;
                            TASK_QUEUE.wait();
                        } catch (InterruptedException e) {
                            break Outer;
                        }
                    }
                    task = TASK_QUEUE.removeFirst();
                }


                if (task != null) {
                    this.taskState = TaskState.RUNNING;
                    task.run();
                    this.taskState = TaskState.FREE;
                }
            }

            Optional.of(Thread.currentThread() + " 已经销毁。").ifPresent(System.out::println);
        }

        public WorkerTask(ThreadGroup group, String name) {
            super(group, name);
        }

        public void close() {
            this.taskState = TaskState.DEAD;
        }
    }
}