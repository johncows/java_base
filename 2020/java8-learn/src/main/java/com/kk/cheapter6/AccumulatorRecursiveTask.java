package com.kk.cheapter6;

import java.util.concurrent.RecursiveTask;

/**
 * @author wangjunkang
 * @version 1.0
 * @description: TODO
 * @date 2020/12/1 下午9:04
 */
public class AccumulatorRecursiveTask extends RecursiveTask<Integer> {



    private final int start;

    private final int end;

    private final int[] data;

    private final int limit = 3 ;


    public AccumulatorRecursiveTask(int start, int end, int[] data) {
        this.start = start;
        this.end = end;
        this.data = data;
    }

    @Override
    protected Integer compute() {
        if(end-start<limit){
            int result = 0;
            for(int i = start ; i<end;i++){
                result+=data[i];
            }
            return result;
        }
        int mid_value = (start+end)/2;
        AccumulatorRecursiveTask left = new AccumulatorRecursiveTask(start,mid_value,data);
        AccumulatorRecursiveTask right = new AccumulatorRecursiveTask(mid_value,end,data);
        left.fork();
        Integer compute = right.compute();
        Integer join = left.join();
        return compute+join;
    }


}
