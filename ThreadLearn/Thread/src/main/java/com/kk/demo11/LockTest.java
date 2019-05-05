package com.kk.demo11;

import java.util.stream.Stream;

public class LockTest {


    public static void main(String[] args) {
        final BooleanLock booleanLock = new BooleanLock(false);
        Stream.of("T1", "T2", "T3", "T4").forEach(name -> new Thread(() -> {
            try {
                booleanLock.lock(30);
                work();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (MyLock.TimeoutException e) {
                System.out.println(e.getMessage());
            } finally {
                booleanLock.unLock();
            }
        }, name).start());
    }

    private static void work() {
        System.out.println(Thread.currentThread().getName() + "  working now");
        try {
            Thread.sleep(10_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "  ending now");
    }

}
