package com.kk.demo01;

/**
 * @author KK
 * @create 2019-05-18 20:35
 *
 * 懒汉式单例 + double check + volatile
 * 优点 可以懒加载 线程安全
 *
 *  关键字 volatile保证 可见性 有序性 不保证原子性
 *
 **/
public class SingletonObject05 {

    private static volatile SingletonObject05 instance ;

    private SingletonObject05(){
        
    }

    public  static SingletonObject05 getInstance(){

        if(instance==null){
            synchronized (SingletonObject05.class) {
                if (instance == null) {
                    instance = new SingletonObject05();
                }
            }
        }
        return SingletonObject05.instance;
    }


}
