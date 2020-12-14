package com.kk.cheapter5;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

/**
 * @author wangjunkang
 * @version 1.0
 * @description: TODO
 * @date 11/28/20 11:38 PM
 */

/**
 * T 元素
 * A 容器
 * R 返回的类型
 */
public class ToListCollector<T> implements Collector<T,List<T>, List<T>> {
    @Override
    public Supplier<List<T>> supplier() {
        p("创建集合");
        return ArrayList::new;
    }

    @Override
    public BiConsumer< List<T>, T> accumulator() {
        p("消费单个元素");
        return List::add;
    }

    // 多线程下的合流操作
    @Override
    public BinaryOperator<List<T>> combiner() {
        p("多线程的合流操作");
        return (list1,list2)->{
            list1.addAll(list2);
            return list1;
        };
    }

    @Override
    public Function<List<T>, List<T>> finisher() {
//        return list->list; 等价
        p("返回传入的集合参数");
        return Function.identity();
    }

    @Override
    public Set<Characteristics> characteristics() {
        p("我也不知道说啥  ");
        return Collections
                .unmodifiableSet(
                        EnumSet.of(Characteristics.IDENTITY_FINISH,
                                Characteristics.CONCURRENT));
    }


    private void p(String s){
        System.out.println(Thread.currentThread()+"-->"+s);
    }
}
