package com.kk.demo14;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author KK
 * @create 2019-05-07 16:43
 **/
public class SimpleThreadPool extends Thread {

    private int threadPoolCapacity;

    private int minThreadPoolCapacity;

    private int maxThreadPoolCapacity;

    private int activeThreadPoolCapacity;


    private static volatile int threadCounter = 0;

//    private final static int DEFAULT_THREAD_POOL_CAPACITY = 10;

    private final static int DEFAULT_TASK_QUEUE_CAPACITY = 2000;

    private final static String THREAD_PREFIX = "SIMPLE_THREAD_POOL-";

    private final static ThreadGroup THREAD_GROUP = new ThreadGroup("Pool_Group");

    private final static ArrayList<WorkerTask> THREADS_QUEUE = new ArrayList<>();

    private final int taskQueueCapacity;

    private final static LinkedList<Runnable> TASK_QUEUE = new LinkedList<>();

    private volatile boolean destroy = false;

    public boolean isDestroy() {
        return destroy;
    }

    private final DiscardPolicy discardPolicy;
    private final static DiscardPolicy DEFAULT_DISCARD_POLICY = () -> {
        throw new DiscardException("Discard This Task.");
    };

    public SimpleThreadPool() {
        this(4, 6, 10, DEFAULT_TASK_QUEUE_CAPACITY, DEFAULT_DISCARD_POLICY);
    }

    public SimpleThreadPool(int minThreadPoolCapacity, int maxThreadPoolCapacity, int activeThreadPoolCapacity, int taskQueueCapacity, DiscardPolicy discardPolicy) {
        this.minThreadPoolCapacity = minThreadPoolCapacity;
        this.maxThreadPoolCapacity = maxThreadPoolCapacity;
        this.activeThreadPoolCapacity = activeThreadPoolCapacity;
        this.taskQueueCapacity = taskQueueCapacity;
        this.discardPolicy = discardPolicy;
        init();
    }

    @Override
    public void run() {
        while (!destroy) {
            System.out.printf("Pool#Min:%d,Max:%d,Active:%d,Current:%d,TaskQueueSize:%d\n",
                    this.minThreadPoolCapacity, this.maxThreadPoolCapacity, this.activeThreadPoolCapacity, this.threadPoolCapacity,
                    TASK_QUEUE.size());

            try {
                Thread.sleep(5000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (TASK_QUEUE.size() > activeThreadPoolCapacity && threadPoolCapacity < activeThreadPoolCapacity) {
                for (int i = threadPoolCapacity; i < activeThreadPoolCapacity; i++) {
                    createWorkTask();
                }
                threadPoolCapacity = activeThreadPoolCapacity;
                System.out.println("基本扩充完毕");
            } else if (TASK_QUEUE.size() > maxThreadPoolCapacity && threadPoolCapacity < maxThreadPoolCapacity) {
                for (int i = threadPoolCapacity; i < activeThreadPoolCapacity; i++) {
                    createWorkTask();
                }
                threadPoolCapacity = maxThreadPoolCapacity;
                System.out.println("最大扩充");
            }

            if (TASK_QUEUE.isEmpty() && threadPoolCapacity > activeThreadPoolCapacity
            ) {
                synchronized (THREADS_QUEUE) {
                    int needCloseNum = threadPoolCapacity - activeThreadPoolCapacity;
                    Iterator<WorkerTask> iterator = THREADS_QUEUE.iterator();
                    while (iterator.hasNext()) {
                        if (needCloseNum <= 0) break;
                        WorkerTask next = iterator.next();
                        if (next.taskState != TaskState.RUNNING) {
                            next.close();
                            next.interrupt();
                            needCloseNum--;
                            iterator.remove();
                            System.out.println(next.getName() + "被释放 ");
                        }
                    }
                }
                threadPoolCapacity = activeThreadPoolCapacity;
            }
        }


    }

    //    线程区别状态
    private enum TaskState {
        FREE, RUNNING, BLOCKED, DEAD
    }


    private static class WorkerTask extends Thread {

        private volatile TaskState taskState = TaskState.FREE;

        public WorkerTask(ThreadGroup group, String name) {
            super(group, name);
        }

        public TaskState getTaskState() {
            return this.taskState;
        }

        public void close() {
            this.taskState = TaskState.DEAD;
        }

        @Override
        public void run() {
            OUTER:
            while (this.taskState != TaskState.DEAD) {
                Runnable task;
                synchronized (TASK_QUEUE) {
                    while (TASK_QUEUE.isEmpty()) {
                        try {
                            taskState = TaskState.BLOCKED;
                            TASK_QUEUE.wait();
                        } catch (InterruptedException e) {
                            break OUTER;
                        }
                    }
                    task = TASK_QUEUE.removeFirst();
                }

                if (task != null) {
                    taskState = TaskState.RUNNING;
                    task.run();
                    taskState = TaskState.FREE;
                }
            }
        }
    }


    private void init() {
        for (int i = 0; i < minThreadPoolCapacity; i++) {
            createWorkTask();
        }
        this.threadPoolCapacity = this.minThreadPoolCapacity;
    }


    private void createWorkTask() {
        WorkerTask workerTask = new WorkerTask(THREAD_GROUP, THREAD_PREFIX + (threadCounter++));
        workerTask.start();
        THREADS_QUEUE.add(workerTask);
    }


    public void submit(Runnable runnable) {
        if (destroy) {
            throw new IllegalStateException("非法状态 不允许添加任务");
        }

        synchronized (TASK_QUEUE) {
            if (TASK_QUEUE.size() > taskQueueCapacity) {
                discardPolicy.discard();
            }
            TASK_QUEUE.add(runnable);
            TASK_QUEUE.notifyAll();
        }
    }


    public static class DiscardException extends RuntimeException {
        public DiscardException(String message) {
            super(message);
        }
    }

    public interface DiscardPolicy {
        void discard() throws DiscardException;
    }


    public void setDestroy(boolean destroy) {
        this.destroy = destroy;
    }

    public void shutdown() throws InterruptedException {

        this.destroy = true;
        while (!TASK_QUEUE.isEmpty()) {
            Thread.sleep(30);
        }
        synchronized (THREADS_QUEUE) {
            int threadPoolCapacity = THREADS_QUEUE.size();
            while (threadPoolCapacity > 0) {
                for (WorkerTask workerTask : THREADS_QUEUE) {
                    if (workerTask.taskState == TaskState.BLOCKED) {
                        workerTask.close();
                        workerTask.interrupt();
                        threadPoolCapacity--;
                    } else {
                        Thread.sleep(30);
                    }
                }
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {
        SimpleThreadPool simpleThreadPool = new SimpleThreadPool(5, 10, 7, 2000, SimpleThreadPool.DEFAULT_DISCARD_POLICY);
//            SimpleThreadPool simpleThreadPool = new SimpleThreadPool();


        for (int i = 0; i < 30; i++) {
            simpleThreadPool.submit(() -> {
                System.out.println(Thread.currentThread().getName().substring(Thread.currentThread().getName().
                        length() - 1, Thread.currentThread().getName().length()) + "号线程接受到任务 并开启服务");
                try {
                    Thread.sleep(5_000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName().substring(Thread.currentThread().getName().
                        length() - 1, Thread.currentThread().getName().length()) + "号线程完成任务 退出任务");

            });
        }

        simpleThreadPool.start();


        Thread.sleep(20_000);

        simpleThreadPool.shutdown();


    }
}
