package org.cheapter10;

import java.util.Optional;
import java.util.stream.IntStream;

public class DemoTest {




    public static void main(String[] args) throws InterruptedException {
        SimpleThreadPool simpleThreadPool = new SimpleThreadPool();

        IntStream.rangeClosed(1,40).forEach(e->{
            simpleThreadPool.submitTask(()->{
                Optional.of("当前任务号为"+e+".").ifPresent(System.out::println);

                try {
                    Thread.sleep(10_000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }

                Optional.of("当前执行的线程编号为"+Thread.currentThread().getName()+".").ifPresent(System.out::println);
            });
        });


        try {
            Thread.sleep(1_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        simpleThreadPool.shutdown();


        IntStream.rangeClosed(1,40).forEach(e->{
            simpleThreadPool.submitTask(()->{
                Optional.of("当前任务号为"+e+".").ifPresent(System.out::println);

                try {
                    Thread.sleep(10_000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }

                Optional.of("当前执行的线程编号为"+Thread.currentThread().getName()+".").ifPresent(System.out::println);
            });
        });

    }



}
