package com.kk.demo04;


public class DaemonTest {




    public static void main(String[]  pp) throws InterruptedException {

        Thread thread = new Thread(()->{
            try {
                Thread.sleep(1_000_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });




        thread.start();


        Thread.sleep(100_000L);
        thread.interrupt();


    }








//
//    public static void main(String[] args) {
//
//
//        Thread thread = new Thread("主线程"){
//            @Override
//            public void run() {
//
//               Thread daemonThread =  new Thread(){
//                    @Override
//                    public void run() {
//                        while (true)
//                            System.out.println("守护线程工作中");
//                    }
//                };
//
//               daemonThread.setDaemon(true);
//               daemonThread.start();
//
//            }
//        };
//
//        thread.start();
//
//
//        while(true){
//            System.out.println("我是main线程");
//            try {
//                Thread.sleep(1_000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//
//    }


}
