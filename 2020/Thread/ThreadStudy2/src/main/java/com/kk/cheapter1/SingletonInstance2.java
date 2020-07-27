package com.kk.cheapter1;


/**
 *  利用虚拟机的加载机制，确保懒汉单例模式的正确加载，推荐
 *
 */
public class SingletonInstance2 {

    private SingletonInstance2() {
        System.out.println("我被实例化了");
    }

    private static class InnerClass {
        private static final SingletonInstance2 SINGLETONINSTANCE2 = new SingletonInstance2();
    }

    public static SingletonInstance2 getInstance() {
        return InnerClass.SINGLETONINSTANCE2;
    }

    public static void main(String[] args) {
        System.out.println(SingletonInstance2.getInstance());
    }

}
