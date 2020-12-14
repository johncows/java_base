package com.kk.cheapter6;

import java.util.concurrent.RecursiveAction;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author wangjunkang
 * @version 1.0
 * @description: TODO
 * @date 2020/12/1 下午9:22
 */
public class AccumulatorRecursiveAction extends RecursiveAction {

    private final int start;

    private final int end;

    private final int[] data;

    private final int limit = 3;


    public AccumulatorRecursiveAction(int start, int end, int[] data) {
        this.start = start;
        this.end = end;
        this.data = data;
    }

    @Override
    protected void compute() {
        if (end - start < limit) {
            for (int i = start; i < end; i++) {
                AccumulatorHelper.accumulator(data[i]);
            }
        } else {
            int mid_value = (start + end) / 2;
            AccumulatorRecursiveAction left = new AccumulatorRecursiveAction(start, mid_value, data);
            AccumulatorRecursiveAction right = new AccumulatorRecursiveAction(mid_value, end, data);
            left.fork();
            right.fork();
            left.join();
            right.join();
        }
    }


    static class AccumulatorHelper{
        private static  final  AtomicInteger result = new AtomicInteger(0);

        public static void accumulator(int value){
            result.addAndGet(value);
        }

        public static int getValue(){
            return result.get();
        }

        public void reset(){
            result.set(0);
        }
    }
}
