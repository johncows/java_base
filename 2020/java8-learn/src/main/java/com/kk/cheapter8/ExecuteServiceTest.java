package com.kk.cheapter8;

import java.util.Optional;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author wangjunkang
 * @version 1.0
 * @description: TODO
 * @date 2020/12/3 上午9:55
 */
public class ExecuteServiceTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<?> hello = executorService.submit(() -> {
            Thread.sleep(10_000);
            return "zhangsan";
        });

        Optional.ofNullable(hello.get()).ifPresent(System.out::println);

        executorService.shutdown();
    }
}
