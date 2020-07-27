package com.kk.cheapter1;

/**
 * 标准的懒汉式类加载过程 双重锁判定+volatile
 */
public class SingletonInstance1 {

    private static volatile SingletonInstance1 singletonInstance;

    private SingletonInstance1() {
        System.out.println("私有构造器");
    }

    public static SingletonInstance1 getInstance() {
        if (singletonInstance == null) {
            synchronized (SingletonInstance1.class) {
                if (singletonInstance == null) {
                    singletonInstance = new SingletonInstance1();
                }
            }
        }
        return singletonInstance;
    }
}
