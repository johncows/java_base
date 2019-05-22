package com.kk.demo04.version2;

/**
 * @author KK
 * @create 2019-05-22 21:50
 **/
public class SleepObserver extends Observer {

    public SleepObserver(String name, Subject subject) {
        super(name, subject);
    }

    @Override
    public void update() {
        System.out.println(name+" "+ " 快别睡觉了 " +subject.getCurrentStatus());
    }
}
