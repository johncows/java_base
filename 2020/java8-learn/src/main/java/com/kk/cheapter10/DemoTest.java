package com.kk.cheapter10;

import java.util.Optional;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author wangjunkang
 * @version 1.0
 * @description: TODO
 * @date 2020/12/3 下午8:05
 */
public class DemoTest {

   private static  Random random =  new Random(System.currentTimeMillis());

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Double> completableFuture = new CompletableFuture<>();

        new Thread(()->{
            double value = get();
            completableFuture.complete(value);
        }).start();

        System.out.println("not blocking");

//        Optional.ofNullable(completableFuture.get()).ifPresent(System.out::println);

        // 事件未注册，采用流式处理
        completableFuture.whenComplete((v,t)->{
            Optional.ofNullable(v).ifPresent(System.out::println);
            Optional.ofNullable(t).ifPresent(x->x.printStackTrace());
        });

    }

    public static double get(){
        try {
            Thread.sleep(random.nextInt(10_000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return random.nextDouble();
    }
}
