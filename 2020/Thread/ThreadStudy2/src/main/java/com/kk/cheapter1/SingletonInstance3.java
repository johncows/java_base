package com.kk.cheapter1;

public class SingletonInstance3 {

    private SingletonInstance3() {
    }

    private enum Singleton {
        INSTANCE;
        private final SingletonInstance3 instance;

        Singleton() {
            System.out.println("hello");
            instance = new SingletonInstance3();
        }

        public SingletonInstance3 getInstance() {
            return instance;
        }
    }

    public static SingletonInstance3 getInstance() {
        return Singleton.INSTANCE.getInstance();
    }

}
