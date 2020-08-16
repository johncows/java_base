package com.kk.cheapter3;

/**
 *  通过 volatile关键字，使得线程可以感知到变量的改变
 *
 *  核心思想
 *  1. 在cpu写入数据时，如果发现该变量被共享（其他Cpu中也存在该变量的副本），会发出一个信号，通知其他cpu变量的缓存无效
 *  2. 其他cpu访问该变量时，直接去主内存中获取
 *
 */
public class VolatileDemo {

    private static volatile int INIT_VALUE = 1;

    private static final int MAXVALUE = 6;


    public static void main(String[] args) {



        new Thread(()->{
            int  localValue = INIT_VALUE;
            while(localValue < MAXVALUE){
                if(localValue!=INIT_VALUE){
                    System.out.println(" the value updated "+ INIT_VALUE);
                    localValue = INIT_VALUE;
                }
            }
        }).start();



        new Thread(()->{
            int  localValue = INIT_VALUE;
            while(localValue < MAXVALUE){
                System.out.println("update the value to "+ ++INIT_VALUE);
                localValue = INIT_VALUE;
                try {
                    Thread.sleep(1_000);
                } catch (InterruptedException e) {

                }
            }
        }).start();





    }
}
