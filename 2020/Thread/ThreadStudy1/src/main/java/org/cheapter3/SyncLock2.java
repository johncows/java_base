package org.cheapter3;

public class SyncLock2 {


    public static synchronized void fun1() {
        System.out.println("开始唱歌吧");
        try {
            Thread.sleep(10_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("结束唱歌吧");

    }


    public static synchronized void fun2() {
        System.out.println("开始跳舞吧");
        try {
            Thread.sleep(10_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("结束跳舞吧");
    }

}
