package com.kk.demo01;

/**
 * @author KK
 * @create 2019-05-18 20:35
 *
 * 饿汉式单例
 * 优点 可以懒加载
 * 缺点 非线程安全
 *
 **/
public class SingletonObject02 {

    private static  SingletonObject02 instance ;

    private SingletonObject02(){
        
    }

    public static SingletonObject02 getInstance(){
        if(instance==null){
            instance = new SingletonObject02();
        }
        return SingletonObject02.instance;
    }


}
