package com.kk.run;

import com.kk.demo.CounterDownDemo;
import org.junit.Test;
import sun.reflect.generics.tree.VoidDescriptor;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class DemoTest {


//    基本线程
    public static  void fun1(){
        CounterDownDemo counterDownDemo1 = new CounterDownDemo();
        CounterDownDemo counterDownDemo2 = new CounterDownDemo();
        new Thread(counterDownDemo1).start();
        new Thread(counterDownDemo2).start();
    }


    /**
     *      利用执行器来管理线程
     */
    public static void fun2(){

        CounterDownDemo counterDownDemo1 = new CounterDownDemo();
        CounterDownDemo counterDownDemo2 = new CounterDownDemo();

//       CachedThreadPool 会为每个任务创建一个线程
        ExecutorService executorService = Executors.newCachedThreadPool();

//        置入操纵器中
        executorService.execute(counterDownDemo1);
        executorService.execute(counterDownDemo2);

//      阻止操纵器再次接受任务 但当前任务会执行完毕
        executorService.shutdown();

//        无法插入
//        executorService.execute(new CounterDownDemo());

    }


    /**
     *      FixedThreadPool 提前预估需要消耗的开销
     */
    public static void fun3(){
        ExecutorService service = Executors.newFixedThreadPool(3);
        service.execute(new CounterDownDemo());
        service.execute(new CounterDownDemo());
        service.execute(new CounterDownDemo());
        service.shutdown();
    }

    /**
     *      SingleThreadExecutor 进程顺序执行 用于访问文件等资源
     */
    public static void fun4(){
        ExecutorService service = Executors.newSingleThreadExecutor();
        service.execute(new CounterDownDemo());
        service.execute(new CounterDownDemo());
        service.execute(new CounterDownDemo());
        service.shutdown();
    }



    public static void main(String[] args) {
        fun4();
    }
}
