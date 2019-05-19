package com.kk.demo03;

/**
 * @author KK
 * @create 2019-05-18 22:10
 **/
public class VolatileTest02 {

    private  static volatile int INIT_VALUE = 0;

    private final static int MAX_VALUE = 20;

    public static void main(String[] args) {

        new Thread(()->{


            while (INIT_VALUE<MAX_VALUE){
                    System.out.println("T1->"+ ++INIT_VALUE);
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        },"read").start();


        new Thread(()->{
            while (INIT_VALUE<MAX_VALUE){
                    System.out.println("T2->"+ ++INIT_VALUE);
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"update").start();



    }



}
