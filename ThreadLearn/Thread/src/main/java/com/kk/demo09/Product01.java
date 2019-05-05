package com.kk.demo09;

public class Product01 {

    private int productId = 0;

    private final Object LOCK = new Object();

    //    生产线上是否有产品
    private static boolean flag = false;

    public void consume() {
        synchronized (LOCK) {
            if (!flag) {
                try {
                    LOCK.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("用户为"+Thread.currentThread().getName()+"消费产品ID为" + productId);
                flag = !flag;
                LOCK.notify();
            }
        }
    }


    public void produce() {
        synchronized (LOCK) {
            if (flag) {
                try {
                    LOCK.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("用户为"+Thread.currentThread().getName()+"生产产品ID为" + ++productId);
                flag = !flag;
                LOCK.notify();
            }
        }
    }


}
