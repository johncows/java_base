package com.kk.cheapter1.domain;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class FilterApple {

    @FunctionalInterface
    interface AppleFilter{
        boolean filter(Apple apple);
    }


    static class greenAndWeight implements AppleFilter{
        @Override
        public boolean filter(Apple apple) {
            return apple.getColor().equals("GREEN")&&apple.getWeights().compareTo(50)>0;
        }
    }

    public static List<Apple> findApple(List<Apple> appleList,AppleFilter appleFilter){
        return appleList.stream().filter(apple -> appleFilter.filter(apple)).collect(Collectors.toList());
    }


    public static void main(String[] args) {
        List<Apple> apples = Arrays.asList(new Apple());
        findApple(apples,apple -> true);


        findApple(apples, new AppleFilter() {
            @Override
            public boolean filter(Apple apple) {
                return false;
            }
        });


        Supplier<Apple> appleCallable = () -> {
            return new Apple();
        };

        Supplier<Integer> integerCallable = () -> {
            int i = 42;
            return i;
        };


//        BiPredicate biPredicate


        Thread thread = new Thread();

        Thread thread1 = new Thread(thread::run);


    }


    @Test
    public  void fun1(){
        List<String> numStr =Arrays.asList("1","2","3");
        List<Integer> collect = numStr.stream().map(Integer::parseInt).collect(Collectors.toList());
        System.out.println("collect = " + collect);
    }

     @Test
     public  void fun2(){
        // 无参数的情况
         Supplier supplier = String::new;
         Object o = supplier.get();
         System.out.println("o = " + o);

         // 有参数的情况
         Function<String, String> function = String::new;
         String name = function.apply("王骏康");
         System.out.println("王骏康 = " + name);


         // 多个参数的情况下·
         BiFunction<String,Integer,Apple> biFunction = Apple::new;
         Apple green = biFunction.apply("green", 10);
         System.out.println("green = " + green);

     }


}
