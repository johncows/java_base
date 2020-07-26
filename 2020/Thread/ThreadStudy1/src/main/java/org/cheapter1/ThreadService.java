package org.cheapter1;


/**
 * 强制打断线程
 */
public class ThreadService {

    // 执行线程
    private Thread executeThread;

    private boolean flag = false;

    public void execute(Runnable runnable) {
        executeThread = new Thread(() -> {
            Thread thread = new Thread(runnable);
            thread.setDaemon(true);
            thread.start();
            try {
                // 执行线程被block
                thread.join();
                flag = true;
            } catch (InterruptedException e) {
                System.out.println("王哥 你可超时了");
                flag = true;
//                e.printStackTrace();
            }
        });
        executeThread.start();
    }

    public void shutdown(long mile) {
        long end = System.currentTimeMillis() + mile;
        while (!flag) {
            if (System.currentTimeMillis() > end){
                System.out.println("任务超时 强制结束");
                executeThread.interrupt();
            }
        }
    }

}
