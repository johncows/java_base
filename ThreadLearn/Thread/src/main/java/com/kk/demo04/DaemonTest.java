package com.kk.demo04;

public class DaemonTest {


    public static void main(String[] args) {

        Thread thread1 = new Thread() {

            @Override
            public void run() {

                Thread daemonThread = new Thread() {
                    @Override
                    public void run() {
                        while (true) {
                            System.out.println("守护中");
                            try {
                                Thread.sleep(1_000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                };

                daemonThread.setDaemon(true);
                daemonThread.start();
            }
        };

        thread1.start();



        while(true){
            System.out.println("我是main线程");
            try {
                Thread.sleep(1_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }


}
