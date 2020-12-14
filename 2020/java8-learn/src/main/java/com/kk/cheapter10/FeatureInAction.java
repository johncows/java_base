package com.kk.cheapter10;


import java.sql.SQLOutput;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author wangjunkang
 * @version 1.0
 * @description: TODO
 * @date 2020/12/3 下午7:43
 */
public class FeatureInAction {


    public static void main(String[] args) {
        Future<String> invoke = invoke(() -> {
            try {
                Thread.sleep(10_000);
                return "i am Finished";
            } catch (InterruptedException e) {
                return "i am in a ERROR";
            }
        });

        invoke.setCompletable(new Completable<String>() {
            @Override
            public void complete(String s) {
                System.out.println("s = " + s);
            }

            @Override
            public void exception(Exception canse) {
                System.out.println("error = " + canse);
            }
        });


        System.out.println("invoke.get() = " + invoke.get());

    }


    private static <T> Future<T> invoke(Callable<T> callable) {

        AtomicReference<T> result = new AtomicReference();
        AtomicBoolean flag = new AtomicBoolean(false);


        Future<T> future = new Future<T>() {

            private Completable<T> completable;

            @Override
            public T get() {
                return result.get();
            }

            @Override
            public boolean isDone() {
                return flag.get();
            }

            @Override
            public void setCompletable(Completable<T> completable) {
                this.completable = completable;
            }

            @Override
            public Completable<T> getCompletable() {
                return completable;
            }
        };


        Thread thread = new Thread(() -> {
            try{
                T value = callable.action();
                result.set(value);
                flag.set(true);
                if(future.getCompletable()!=null){
                    future.getCompletable().complete(value);
                }
            }catch (Exception e){
                if(future.getCompletable()!=null){
                    future.getCompletable().exception(e);
                }
            }
        });

        thread.start();
        return future;
    }
}
