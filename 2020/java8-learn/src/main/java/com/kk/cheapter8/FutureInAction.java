package com.kk.cheapter8;


import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author wangjunkang
 * @version 1.0
 * @description: TODO
 * @date 2020/12/2 下午9:00
 */
public class FutureInAction {


    public static void main(String[] args) throws InterruptedException {
        Future<String> invoke = invoke(() -> {
            try {
                Thread.sleep(10_000);
                return "fininsh";
            } catch (Exception e) {
                return "error";
            }
        });
        System.out.println("invoke = " + invoke.get());
        Thread.sleep(11_000);
        System.out.println("invoke = " + invoke.get());
        System.out.println("invoke = " + invoke.get());
        System.out.println("invoke = " + invoke.get());
    }


    private static <T>Future<T> invoke(Callable<T> callable){

        AtomicReference<T> result = new AtomicReference();
        AtomicBoolean flag = new AtomicBoolean(false);


        Thread thread = new Thread(() -> {
            T value = callable.action();
            result.set(value);
            flag.set(true);
        });
        thread.start();

        Future<T> future = new Future<T>() {

            @Override
            public T get() {
                return result.get();
            }

            @Override
            public boolean isDone() {
                return flag.get();
            }
        };
        return  future;
    }
}
