package com.kk.demo05.force;


public class ThreadServer {

    private Thread executeThread;

    private boolean finished = false;


    public void execute(Runnable task) {

        executeThread = new Thread("执行线程") {

            @Override
            public void run() {

                Thread taskThread = new Thread(task, "任务线程");
//                设置任务线程为守护线程
                taskThread.setDaemon(true);
//                开启线程
                taskThread.start();


                try {
//                    任务线程执行完 再执行下一步
                    System.out.println("卡在这个位置");
                    taskThread.join();
                    System.out.println("不再等待任务线程结束 执行线程先运行了");
                    finished = true;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        executeThread.start();
    }




    public void stopThread(long maxTime){
        long start = System.currentTimeMillis();

        while(!finished){
            if(System.currentTimeMillis()-start>=maxTime){
                System.out.println("任务已经超时 需要强制结束");
                executeThread.interrupt();
                break;
            }
        }
        finished = false;

    }


}
