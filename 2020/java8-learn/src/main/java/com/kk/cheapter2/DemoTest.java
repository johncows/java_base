package com.kk.cheapter2;

import com.kk.cheapter2.domain.Dish;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class DemoTest {

    private static long start;

    private static List<Dish> getList() {
        return Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHERS),
                new Dish("rice", true, 350, Dish.Type.OTHERS),
                new Dish("season fruit", true, 120, Dish.Type.OTHERS),
                new Dish("pizza", true, 500, Dish.Type.OTHERS),
                new Dish("pizza", true, 501, Dish.Type.OTHERS),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH)
        );
    }

    @Test
    public void fun1() {
        Predicate<Dish> predicate = a -> {
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return a.getCalories() < 400;
        };
        List<Dish> dishList = getList();
        // 获取卡路里小于400的食品,再排序
        // 先筛选，再排序
        List<String> dishNameList = dishList
                .parallelStream()
                .filter(predicate)
                .sorted(Comparator.comparingInt(Dish::getCalories))
                .map(dish -> {
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return dish.getName();
                })
                .collect(Collectors.toList());
        dishNameList.forEach(System.out::println);
    }


    @Test
    public void fun4() {


        Arrays.asList(1, 10).parallelStream().filter(f -> {
            System.out.println(f + " 任务执行筛选操作");
            try {
                Thread.sleep(f * 1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(f + " 任务完成筛选操作");
            return true;
        }).forEach(f -> {
                    System.out.println(f + " 任务执行筛选操作");
                    try {
                        Thread.sleep(f * 1000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(f + " 任务完成筛选操作");
                }
        );
    }


    public static void main(String[] args) {

        DemoTest demoTest = new DemoTest();
        demoTest.start();

        demoTest.fun4();

        demoTest.end();

    }


    /**
     *  Stream 匹配
     */
    @Test
    public void fun5(){
        boolean match = getList().stream().allMatch(this::ifHaveCalories);
        System.out.println(match);

        match = getList().stream().anyMatch(this::ifHaveCalories);
        System.out.println(match);

        match = getList().stream().noneMatch(this::ifHaveCalories);
        System.out.println(match);
    }




     @Test
     public  void fun6(){
         Optional<Dish> optionalDish = getList().stream().filter(this::ifHaveCalories).findAny();
         optionalDish.ifPresent(System.out::println);
     }


      @Test
      public  void fun7(){
          // 找到最大的calories
          Optional<Integer> reduce = getList().stream().map(Dish::getCalories).reduce((a, b) -> a > b ? a : b);
          System.out.println("reduce = " + reduce.get());
      }


       @Test
       public  void fun8(){
            // 计算食物的数量
           Optional<Integer> reduce = getList().stream().map(a -> 1).reduce((a, b) -> a + b);
           System.out.println("食物总数为"+reduce.get());


       }


    private Boolean ifHaveCalories(Dish dish){
        return dish.getCalories()>400?true:false;
    }


    @Before
    public void start() {
        start = System.currentTimeMillis();
    }

    @After
    public void end() {
        long end = System.currentTimeMillis();
        System.out.printf("运行程序耗时 " + (end - start));
    }

    @Test
    public void fun() {
        int[] ints = {0, 4, 3, 0};
        int[] ints1 = twoSum(ints, 0);
        System.out.println(ints1[0] + "----" + ints1[1]);
    }

    public int[] twoSum(int[] nums, int target) {
        int arr[] = new int[2];
        boolean flag = true;
        for (int i = 0; i < nums.length - 1 && flag; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    arr[0] = i;
                    arr[1] = j;
                    flag = false;
                    break;
                }
            }
        }
        return arr;
    }


    @Test
    public void fun2() throws IOException {
        getList().stream().distinct().forEach(System.out::println);
    }

    // 自增生成组编号
    static int group = 1;
    // 自增生成学生编号
    static int student = 1;

    @Test
    public void fun3() {
        List<String[]> eggs = new ArrayList<>();
        eggs.add(new String[]{"鸡蛋_1", "鸡蛋_1", "鸡蛋_1", "鸡蛋_1", "鸡蛋_1"});
        eggs.add(new String[]{"鸡蛋_2", "鸡蛋_2", "鸡蛋_2", "鸡蛋_2", "鸡蛋_2"});
        //  相当于将多层数据通过漏斗变成一条流
        eggs.stream()
                .flatMap(x -> Arrays.stream(x).map(y -> y.replace("鸡", "煎")))
                .forEach(x -> System.out.println("x = " + x));
    }
}
