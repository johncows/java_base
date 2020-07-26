package org.cheapter3;

public class ThreadTest {

    public static void main(String[] args) {
        SyncLock2 syncLock1=  new SyncLock2();
        SyncLock2 syncLock2=  new SyncLock2();


        Thread thread1 = new Thread(() -> {
            syncLock1.fun1();
        });

        Thread thread2 = new Thread(() -> {
            syncLock2.fun2();
        });
        thread1.start();
        thread2.start();
    }


}
