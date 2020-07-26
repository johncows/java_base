package com.kk.demo;

import java.util.Random;

public class CounterDownDemo implements Runnable {

    //    倒计时的总数
    public int count = 10;

    private static int threadId = 0;

    private final int id = threadId++;

    //    倒计时发射
    private void Status() {
        if (count != 0) {
            System.out.format("线程号 %d -------倒计时还有%d \n", id, count);
        } else {
            System.out.println("++++++++已发射++++++");
        }
    }

    int level;

    {
        level = new Random().nextInt(8) + 2;
    }


    @Override
    public void run() {
        while (count-- > 0) {
            Status();
//                Thread.yield();
            Thread.currentThread().setPriority(level);
            System.out.println(Thread.currentThread());
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }


    //  Sleep代码
//    @Override
//    public void run() {
//        Random random = new Random();
//
//        long i = random.nextInt(2000) + 1000;
//
//        try {
//            System.out.println("我要睡的时间是 " + i+"毫秒");
//            Thread.sleep(i);
//            System.out.println("我醒了");
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
}
