package com.kk.demo03;

import java.util.Arrays;

public class CreateThread {

    public static void main(String[] args) {
        System.out.println(" hello");
        Thread thread = new Thread();
        thread.start();




        ThreadGroup threadGroup = thread.getThreadGroup();

        System.out.println("threadGroup = " + threadGroup.activeCount());

        Thread []threads = new Thread[threadGroup.activeCount()];

        threadGroup.enumerate(threads);

        Arrays.asList(threads).forEach(System.out::println);

    }
}
