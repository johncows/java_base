package com.kk.demo01;

public class ThreadTest01 {

    public static void main(String[] args) {

        Thread thread = new Thread() {
            @Override
            public void run() {

                try {
                    Thread.sleep(100_000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };


        thread.start();

    }






}
