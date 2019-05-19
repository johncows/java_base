package com.kk.demo03;

/**
 * @author KK
 * @create 2019-05-18 22:10
 *
 * 代码目的:
 *      测试在对多线程下对某个变量进行读写时 volatile关键字的作用
 *
 * 测试结果:
 *      无volatile情况下 write线程对某值进行更新操作时 read无法检测到该值的变化
 *
 * 测试结论:
 *      在无volatile情况下 read线程在只读情况下 会从缓存中拿数据 缓存的不一致性是诱因
 *
 **/
public class VolatileTest01 {

    private  static  int INIT_VALUE = 0;

    private final static int MAX_VALUE = 20;

    public static void main(String[] args) {

/**
 *   该线程对INIT_VALUE进行监控 注意该代码块仅仅是对局部变量进行修改 并无其他读写操作
 */
        new Thread(()->{
            int  localValue = INIT_VALUE;
            while (localValue<MAX_VALUE){
                if(localValue != INIT_VALUE){
                    System.out.println("the Value is update to "+INIT_VALUE);
                    localValue =  INIT_VALUE;
                }
            }

        },"read").start();


/**
 *  该线程 先对局部变量 localValue 自增 再赋值给INIT_VALUE 就是对INIT_VALUE的修改
 *  1.该线程中的localValue 与 write线程中的localValue不是一个变量
 */
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
