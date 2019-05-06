package com.kk.demo13;

/**
 * @author KK
 * @create 2019-05-06 21:55
 **/
public class GroupThread {

    public static void main(String[] args) {

        ThreadGroup tg1 = new ThreadGroup("TG1");

        Thread thread1 = new Thread(tg1, () -> {
            try {
                Thread.sleep(10_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t1");

        Thread thread2 = new Thread(tg1, () -> {
            try {
                Thread.sleep(10_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t2");


        thread1.start();
        thread2.start();

//        获取该线程组下的活跃线程
        int i = thread1.getThreadGroup().activeCount();
        Thread[] threads = new Thread[i];
//        将活跃线程放入Thread数组中
        thread1.getThreadGroup().enumerate(threads);

        tg1.checkAccess();
        tg1.destroy();

    }
}
