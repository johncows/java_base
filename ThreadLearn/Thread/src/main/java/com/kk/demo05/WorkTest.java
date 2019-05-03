package com.kk.demo05;

import org.junit.Test;

public class WorkTest {

    @Test
    public void test01() {
        Thread thread01 = new Thread(new Worker01(), "工人一号");
        Thread thread02 = new Thread(new Worker02(), "工人二号");
        thread01.start();
        thread02.start();

        try {
            Thread.sleep(50_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Worker01.stopWork();
    }


    public static  void main(String[] args) {

        Thread thread01 = new Thread(new Worker02(), "一号工人");
        Thread thread02 = new Thread( new Worker02(),"二号工人");

        thread01.start();
        thread02.start();

        try {
            Thread.sleep(20_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread01.interrupt();

    }
    
    
    
    
    
    
    
}
