package com.kk.demo12;

/**
 * @author KK
 * @create 2019-05-06 21:10
 **/
public class CaptureExceptionForThread {


    private static int A = 10;

    private static int B = 0;

    public static void main(String[] args) {

        Thread thread = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(1_000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                int i = A / B;
            }
        },"线程1号");

        // 捕获后 目标线程会终止执行
        thread.setUncaughtExceptionHandler((t,e)->{
            System.out.println("t.getName() = " + t.getName());
            System.out.println("e.getMessage() = " + e.getMessage());
        });

        thread.start();



    }




}
