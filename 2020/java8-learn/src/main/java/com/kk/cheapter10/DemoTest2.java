package com.kk.cheapter10;

import org.junit.Test;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author wangjunkang
 * @version 1.0
 * @description: TODO
 * @date 2020/12/3 下午8:17
 */
public class DemoTest2 {
    public static void main(String[] args) throws InterruptedException {

        new DemoTest2().fun1();


    }


    @Test
    public  void fun2(){
        ExecutorService executorService = Executors.newFixedThreadPool(2,r->{
            Thread thread = new Thread(r);
            thread.setDaemon(true);
            return thread;
        });
        executorService.execute(()-> System.out.println("test"));
    }


     @Test
     public  void fun1(){
         ExecutorService executorService = Executors.newFixedThreadPool(2);
         executorService.execute(()-> System.out.println("test"));
         executorService.shutdown();
     }


      @Test
      public  void fun() throws InterruptedException {
          AtomicBoolean atomicBoolean = new AtomicBoolean(false);

          // 守护线程 主线程结束，其他
          CompletableFuture.supplyAsync(DemoTest::get).whenComplete((v,t)->{
              Optional.ofNullable(v).ifPresent(System.out::println);
              Optional.ofNullable(t).ifPresent(System.out::println);
              atomicBoolean.set(true);
          });
          System.out.println("not blocking");


          while (!atomicBoolean.get()){
              Thread.sleep(50);
          }
          System.out.println("终于结束了");

//        Thread.currentThread().join();
      }


}
