package com.kk.demo08;

public class DeadLockTest {
    public static void main(String[] args) {
        OtherService otherService = new OtherService();
        DeadLock deadLock = new DeadLock(otherService);
        otherService.setDeadLock(deadLock);
        new Thread() {
            @Override
            public void run() {
                while (true) {
                    deadLock.m2();
                }
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                while (true)
                    otherService.s2();
            }
        }.start();
    }
}