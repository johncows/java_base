package com.kk.demo04.version1;

/**
 * @author KK
 * @create 2019-05-22 21:15
 *
 *
 * 观察者模式 版本1
 *
 *
 * 缺点 观察者依赖目标对象 目标对象依赖观察者
 *
 * 问题 一旦出现需要去提醒 睡觉的员工
 *      明显该类违反了开放/封闭原则 即开放代码扩展 封闭代码修改
 *
 **/
public class DemoTest {
    public static void main(String[] args) {
        Secretary secretary = new Secretary();
        secretary.setSecretaryStatus("一切安全");

        StockObserver observer2 = new StockObserver("老王", secretary);
        StockObserver observer1 = new StockObserver("老李", secretary);

        secretary.attach(observer1);
        secretary.attach(observer2);


//        出现问题了


        secretary.setSecretaryStatus("紧急情况 注意 注意!!!!!");


        secretary.notifyAllStockObserver();


    }
}
