package com.kk.demo01;

/**
 * @author KK
 * @create 2019-05-18 20:35
 *
 * 懒汉式单例+方法锁
 * 优点 可以懒加载 线程安全
 * 缺点 每次调用都会阻塞 程序变慢
 *
 **/
public class SingletonObject03 {

    private static SingletonObject03 instance ;

    private SingletonObject03(){
        
    }

    public synchronized static SingletonObject03 getInstance(){
        if(instance==null){
            instance = new SingletonObject03();
        }
        return SingletonObject03.instance;
    }


}
