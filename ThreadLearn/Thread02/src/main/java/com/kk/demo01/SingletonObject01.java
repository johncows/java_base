package com.kk.demo01;

/**
 * @author KK
 * @create 2019-05-18 20:35
 *
 * 饿汉式单例
 * 优点 线程安全
 * 缺点 无法懒加载
 *
 **/
public class SingletonObject01 {

    private static final SingletonObject01 instance = new SingletonObject01();

    private SingletonObject01(){

    }

    public static SingletonObject01 getInstance(){
        return instance;
    }


}
