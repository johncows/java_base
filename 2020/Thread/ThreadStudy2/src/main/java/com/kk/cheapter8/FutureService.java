package com.kk.cheapter8;

import java.util.function.Consumer;

public class FutureService {

    public <T> Future<T> submit(final FutureTask<T> futureTask){
        Future<T> asyncFuture = new AsyncFuture<>();
        Thread t =new Thread(()->{
            T result = futureTask.call();
            asyncFuture.done(result);
        });
        t.start();
        return asyncFuture;
    }



    public <T> Future<T> submit(final FutureTask<T> futureTask, final Consumer<T> consumer){
        Future<T> asyncFuture = new AsyncFuture<>();
        Thread t =new Thread(()->{
            T result = futureTask.call();
            asyncFuture.done(result);
            consumer.accept(result);
        });
        t.start();
        return asyncFuture;
    }
}
