package com.kk.cheapter5;

import com.kk.cheapter2.domain.Dish;
import org.junit.Test;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.stream.Collectors;

/**
 * @author wangjunkang
 * @version 1.0
 * @description: TODO
 * @date 11/28/20 4:10 PM
 */
public class DemoTest {


    private static List<Dish> getList() {
        return Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHERS),
                new Dish("rice", true, 350, Dish.Type.OTHERS),
                new Dish("season fruit", true, 120, Dish.Type.OTHERS),
                new Dish("pizza", true, 500, Dish.Type.OTHERS),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH)
        );
    }


    @Test
    public void fun1() {
        Object collect = getList().stream().collect(new ToListCollector());
        System.out.println("collect = " + collect);
    }

    @Test
    public void fun2() {
        Object collect = getList().parallelStream().collect(new ToListCollector());
        System.out.println("collect = " + collect);
    }

}
