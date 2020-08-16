package com.kk.cheapter4;

public class OctalObserver extends Observer {

    public OctalObserver(Subject subject) {
        super(subject);
    }

    @Override
    public void update() {
        System.out.println("八进制发生了变化");
    }
}
