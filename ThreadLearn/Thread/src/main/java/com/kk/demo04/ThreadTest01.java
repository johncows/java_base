package com.kk.demo04;



public class ThreadTest01 {



    public static void main(String[] args) {

        Thread thread = new Thread(() -> System.out.println("hello world"));

        thread.start();

    }





}
