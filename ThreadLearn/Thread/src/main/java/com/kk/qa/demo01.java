package com.kk.qa;

/**
 * @author KK
 * @create 2019-05-18 20:12
 **/
public class demo01 {

    public static void main(String[] args) throws InterruptedException {
        Worker worker1 = new Worker("一号工作者");
        Worker worker2 = new Worker("二号工作者");
        Worker worker3 = new Worker("三号工作者");


        worker1.start();
        worker1.join();
        worker2.start();
        worker2.join();
        worker3.start();
        worker3.join();





    }


}

class Worker extends Thread{
    public Worker(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"--执行");
    }
}
