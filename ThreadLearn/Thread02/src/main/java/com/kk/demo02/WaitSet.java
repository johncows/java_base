package com.kk.demo02;


import java.util.stream.IntStream;

/**
 * @author KK
 * @create 2019-05-18 21:38
 *
 * 1. 所有的对象都有一个wait set ,用来存放该对象的wait方法之后进入 block状态线程
 * 2. 线程被notify之后不一定立即得到执行(需要抢锁)
 * 3. 线程从wait set中被唤醒的顺序不确定
 **/
public class WaitSet {

    private static final Object LOCK = new Object();

    public static void main(String[] args) throws InterruptedException {
        IntStream.range(1, 10).forEach(i ->
                new Thread(String.valueOf(i)) {
                    @Override
                    public void run() {
                        synchronized (LOCK) {
                            try {
                                System.out.println(Thread.currentThread().getName() + " will come to waitSet");
                                LOCK.wait();
                                System.out.println(Thread.currentThread().getName() + " will leave to waitSet");
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }.start()
        );


        Thread.sleep(5_000L);

        IntStream.range(1, 10).forEach(i ->{
           synchronized (LOCK){
               LOCK.notify();
               try {
                   Thread.sleep(1000);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }

        });


    }
}