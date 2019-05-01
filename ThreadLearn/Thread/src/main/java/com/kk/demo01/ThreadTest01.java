package com.kk.demo01;

public class ThreadTest01 {

    public static void main(String[] args) {

        Thread thread = new Thread() {
            @Override
            public void run() {
                System.out.println("hello");
            }
        };


        thread.start();

    }






}
