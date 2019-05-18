package com.kk.demo03;

/**
 * @author KK
 * @create 2019-05-18 22:10
 **/
public class VolatileTest {

    private  static int INIT_VALUE = 0;

    private final static int MAX_VALUE = 20;

    public static void main(String[] args) {

        new Thread(()->{
            int  localValue = INIT_VALUE;

            while (localValue<MAX_VALUE){

                if(localValue != INIT_VALUE){
                    System.out.println("the Value is update to "+INIT_VALUE);
                    localValue =  INIT_VALUE;
                }

            }

        },"read").start();


        new Thread(()->{
            int  localValue = INIT_VALUE;
            while (INIT_VALUE<MAX_VALUE){
                    System.out.println("update the Value  "+ ++localValue);
                    INIT_VALUE =localValue;
                try {
                    Thread.sleep(500L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"update").start();



    }



}
