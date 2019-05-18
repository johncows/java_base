package com.kk.demo01;

/**
 * @author KK
 * @create 2019-05-18 21:08
 *
 * 懒汉式 + 枚举 (完美版)
 *
 **/
public class SingletonObject07 {

    private SingletonObject07() {
    }

    private enum Singleton{
        INSTANCE;
        private final SingletonObject07 instance;
        Singleton(){
            instance = new SingletonObject07();
        }

        public SingletonObject07 getInstance(){
            return instance;
        }
    }

    public static SingletonObject07 getInstance(){
        return Singleton.INSTANCE.getInstance();
    }

}
