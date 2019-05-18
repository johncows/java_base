package com.kk.demo01;

/**
 * @author KK
 * @create 2019-05-18 20:35
 *
 * 懒汉式单例(优雅款)
 * 优点
 * 1.只有调用特定方法才会创建对象
 * 2.由类加载器加载 线程安全
 *
 **/
public class SingletonObject06 {

    private SingletonObject06(){
    }

    public  static SingletonObject06 getInstance(){
        return InstanceHolder.INSTANCE;
    }


    private static class InstanceHolder{
        private static final SingletonObject06 INSTANCE = new SingletonObject06();
    }

}
