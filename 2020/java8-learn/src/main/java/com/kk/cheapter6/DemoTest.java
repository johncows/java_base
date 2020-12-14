package com.kk.cheapter6;

import org.junit.Test;
import org.w3c.dom.ranges.Range;

import java.util.Optional;
import java.util.OptionalInt;
import java.util.concurrent.ForkJoinPool;
import java.util.function.Consumer;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * @author wangjunkang
 * @version 1.0
 * @description: TODO
 * @date 2020/12/1 下午8:08
 */
public class DemoTest {

    private Long MaxCount = 2_000_000_000L;

    private Long TimeCast = Long.MAX_VALUE;


    private int[] data = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    @Test
    public void fun1() {
        Optional.ofNullable(originCompute()).ifPresent(System.out::println);
        Optional.of("----------------").ifPresent(System.out::println);
        TimeCast = Long.MAX_VALUE;
        Optional.ofNullable(parallelCompute()).ifPresent(System.out::println);
    }

    Long originCompute() {
        long start = System.currentTimeMillis();

        IntStream.range(1, 11).forEach((i) -> {
            int count = 0;
            for (int j = 0; j < MaxCount; j++) {
                count += j;
            }
            long cast = System.currentTimeMillis() - start;
            if (cast < TimeCast) {
                TimeCast = cast;
            }
            System.out.println(Thread.currentThread() + "执行递增完成");
        });
        return TimeCast;
    }

    Long parallelCompute() {
        IntStream.range(1, 11).parallel().forEach((i) -> {
            long start = System.currentTimeMillis();
            int count = 0;
            for (int j = 0; j < MaxCount; j++) {
                count += j;
            }
            long cast = System.currentTimeMillis() - start;
            if (cast < TimeCast) {
                TimeCast = cast;
            }
            System.out.println(Thread.currentThread() + "执行递增完成");
        });
        return TimeCast;
    }


    @Test
    public void fun2() {
        // 不是所有的Stream 都适合并行处理
        /**
         * ArrayList IntStream.range
         *
         * HashSet HashMap
         *
         * LinkedList Stream>iterate
         */
        LongStream.rangeClosed(0, 100).parallel().reduce(Long::sum);
    }


    /**
     * 分而治之
     * <p>
     * 假设 1 - 10 相加
     * <p>
     * 1-5  5-10
     * 1-3 4-5 ====  5-8 8-10
     * 将值在计算中回硕
     */
    @Test
    public void fun3() {

        AccumulatorRecursiveTask accumulatorRecursiveTask = new AccumulatorRecursiveTask(0, data.length, data);

        ForkJoinPool forkJoinPool = new ForkJoinPool();
        Integer invoke = forkJoinPool.invoke(accumulatorRecursiveTask);
        System.out.println(invoke);


        AccumulatorRecursiveAction accumulatorRecursiveAction = new AccumulatorRecursiveAction(0, data.length, data);

        ForkJoinPool forkJoinPool1 = new ForkJoinPool();
         forkJoinPool1.invoke(accumulatorRecursiveAction);
        System.out.println(AccumulatorRecursiveAction.AccumulatorHelper.getValue());



    }



     @Test
     public  void fun4(){
         IntStream intStream = IntStream.rangeClosed(0, 10);
         Consumer<Integer> consumer = e-> System.out.println(e);
         intStream.spliterator().forEachRemaining(consumer);
     }

}
