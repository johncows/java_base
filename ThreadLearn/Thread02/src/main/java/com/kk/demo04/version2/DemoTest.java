package com.kk.demo04.version2;

/**
 * @author KK
 * @create 2019-05-22 21:15
 *
 *
 * 观察者模式 版本2
 *
 * 优点
 * 1. 观察者与主题分别进行抽象
     *    主题不需要去关注观察者的具体实现
     *    观察者也不需要去关注主题的具体实现
 *
 * 缺点
     *   如果观察者没有实现该方法 就无法继续收到通知
     *
 **/
public class DemoTest {
    public static void main(String[] args) {
        Boss boss = new Boss();

        SleepObserver sleepObserver = new SleepObserver("小王", boss);

        boss.attach(sleepObserver);

        boss.setCurrentStatus("我来了");


    }
}
