package com.kk.demo09;

public class Product02 {

    private int productId = 0;

    private final Object LOCK = new Object();

    private static boolean flag = false;


    /*
           注意 方法内部有 if-else 或许使用while来确保
            每次都会判断flag
     */



    public void consume() {
        synchronized (LOCK) {
            if (!flag) {
                try {
                    LOCK.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("c->" + productId);
                flag = !flag;
                LOCK.notifyAll();
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
                System.out.println("p->" + ++productId);
                flag = !flag;
                LOCK.notifyAll();
            }
        }
    }


}
