package com.kk.run;

import com.kk.demo.CounterDownDemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolTest {


    //    基本线程
    public static void fun1() {
        CounterDownDemo counterDownDemo1 = new CounterDownDemo();
        CounterDownDemo counterDownDemo2 = new CounterDownDemo();
        new Thread(counterDownDemo1).start();
        new Thread(counterDownDemo2).start();
    }


    /**
     * 利用执行器来管理线程
     */
    public static void fun2() {

//       CachedThreadPool 会为每个任务创建一个线程
        ExecutorService executorService = Executors.newCachedThreadPool();

//        置入操纵器中
        executorService.execute(new CounterDownDemo());
        executorService.execute(new CounterDownDemo());

//      阻止操纵器再次接受任务 但当前任务会执行完毕
        executorService.shutdown();

//        无法插入
//        executorService.execute(new CounterDownDemo());

    }


    /**
     * FixedThreadPool 提前预估需要消耗的开销
     */
    public static void fun3() {
        ExecutorService service = Executors.newFixedThreadPool(3);
        service.execute(new CounterDownDemo());
        service.execute(new CounterDownDemo());
        service.execute(new CounterDownDemo());
        service.shutdown();
    }

    /**
     * SingleThreadExecutor 进程顺序执行 用于访问文件等资源
     */
    public static void fun4() {
        ExecutorService service = Executors.newSingleThreadExecutor();
        service.execute(new CounterDownDemo());
        service.execute(new CounterDownDemo());
        service.execute(new CounterDownDemo());
        service.shutdown();
    }

    public static void main(String[] args) {
        Thread.currentThread().setDaemon(true);
        ThreadPoolTest.fun2();

    }

}
