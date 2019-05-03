package com.kk.demo07;

public class SynchronizedLock {


    public static void main(String[] args) {

        Thread thread = new Thread(() -> Lock.method3(), "静态锁");
        thread.start();
    }


}


class Lock {

    static {
        System.out.println("hello ");
        synchronized (Lock.class) {
            try {
                System.out.println("抢占的线程为 " + Thread.currentThread().getName());
                Thread.sleep(30_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void method1() {
        try {
            System.out.println("抢占的线程为 " + Thread.currentThread().getName());
            Thread.sleep(30_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void method2() {
        synchronized (this) {
            try {
                System.out.println("抢占的线程为 " + Thread.currentThread().getName());
                Thread.sleep(30_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public static synchronized void method3() {
        try {
            System.out.println("抢占的线程为 " + Thread.currentThread().getName());
            Thread.sleep(30_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}



