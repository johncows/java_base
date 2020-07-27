package com.kk.cheapter2;


import java.util.stream.IntStream;


/**
 *  1. 所有的对象都拥有一个wait-set队列，用来存放调用该对象wait方法后进入block状态的线程
 *  2. 被nofify后的线程不一定立刻执行（blocked-runable-running）
 *  3. 线程从wait队列中被唤醒的顺序不一定是fifo（取决于虚拟机的具体实现）
 *
 *
 */
public class WaitSet {

    private static  final Object LOCK = new Object();


    public static void main(String[] args) {
        IntStream.rangeClosed(1, 40).forEach(e -> {
            new Thread() {
                @Override
                public void run() {
                    synchronized (LOCK) {
                        System.out.println(Thread.currentThread().getName() + " will come to the waitSet");
                        try {
                            LOCK.wait();
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName() + " will leave to the waitSet");
                    }
                }
            }.start();
        });


        try {
            Thread.sleep(5_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        IntStream.rangeClosed(1, 40).forEach(e -> {
            synchronized (LOCK) {
                LOCK.notify();
                try {
                    Thread.sleep(1_000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }


}
