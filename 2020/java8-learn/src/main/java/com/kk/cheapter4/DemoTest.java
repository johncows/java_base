package com.kk.cheapter4;

import com.kk.cheapter2.domain.Dish;
import javafx.scene.Group;
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
        List<Dish> list = getList();
        List<Dish> collect = list.stream().filter(e -> e.getType() == Dish.Type.OTHERS).collect(Collectors.toList());
        Optional.ofNullable(collect).ifPresent(System.out::println);
    }


    @Test
    public void fun2() {
        HashMap<String, List<Dish>> dishMap = new HashMap<>();

        getList().stream().forEach(
                dish -> {
                    List<Dish> dishList = Optional.ofNullable(dishMap.get(dish.getType().name())).orElseGet(() -> {
                        ArrayList<Dish> dishes = new ArrayList<>();
                        dishMap.put(dish.getType().name(), dishes);
                        return dishes;
                    });
                    dishList.add(dish);
                }
        );

        dishMap.forEach((k, v) -> {
            System.out.println(k + "---" + v);
        });
    }


    @Test
    public void fun3() {
        Integer intA = new Integer(12);
        intA = null;
        Integer integer = Optional.ofNullable(intA).orElseGet(() -> 123);
        System.out.println(integer);
    }


    /**
     * @Description: Collector的快速分组 对照fun2（）
     * @Param:
     * @return:
     * @Author: wjk
     * @Date: 11/28/20
     */
    @Test
    public void fun4() {
        Map<Dish.Type, List<Dish>> collect = getList().stream().collect(Collectors.groupingBy(Dish::getType));
        collect.forEach((k, v) -> {
            System.out.println(k + "---" + v);
        });
    }


    /**
     * @Description: 求食品的平均值
     * @Param:
     * @return:
     * @Author: wjk
     * @Date: 11/28/20
     */
    @Test
    public void fun5() {
        Optional.of(getList().stream().collect(Collectors.averagingDouble(Dish::getCalories))).ifPresent(System.out::println);
        Optional.of(getList().stream().collect(Collectors.averagingInt(Dish::getCalories))).ifPresent(System.out::println);
        Optional.of(getList().stream().collect(Collectors.averagingLong(Dish::getCalories))).ifPresent(System.out::println);

    }


    @Test
    public void fun6() {
        Optional.ofNullable(getList().stream().collect(Collectors.collectingAndThen(Collectors.counting(), e -> "食物总数有" + e))).ifPresent(System.out::println);


        // 可被修改结果集的数据
        List<Dish> collect = getList().stream().filter(e -> e.getType().equals(Dish.Type.MEAT)).collect(Collectors.toList());
        collect.add(new Dish());
        Optional.of(collect).ifPresent(System.out::println);


        // 不可被修改结果集
        List<Dish> collect1 = getList().stream().filter(e -> e.getType().equals(Dish.Type.MEAT)).collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
        collect1.add(new Dish());
        Optional.of(collect1).ifPresent(System.out::println);

    }


    @Test
    public void fun7() {
        Optional.ofNullable(getList().stream().collect(Collectors.groupingBy(Dish::getType, Collectors.counting()))).ifPresent(System.out::println);

        Optional.ofNullable(getList().stream().collect(Collectors.groupingBy(Dish::getType, Collectors.averagingDouble(Dish::getCalories)))).ifPresent(System.out::println);

        Optional.ofNullable(getList().stream().collect(Collectors.groupingBy(Dish::getType, ConcurrentHashMap::new, Collectors.averagingDouble(Dish::getCalories)))).ifPresent(System.out::println);
    }

    @Test
    public void fun8() {
        Optional.ofNullable(getList().stream().collect(Collectors.groupingByConcurrent(Dish::getType))).ifPresent(e -> System.out.println(e.getClass()));
    }


    @Test
    public void fun9() {
        Optional.of(getList().stream().map(Dish::getName).collect(Collectors.joining())).ifPresent(System.out::println);

        Optional.of(getList().stream().map(Dish::getName).collect(Collectors.joining("/"))).ifPresent(System.out::println);

        Optional.of(getList().stream().map(Dish::getName).collect(Collectors.joining("/", "<<", ">>"))).ifPresent(System.out::println);


        Optional.ofNullable(getList().stream().collect(Collectors.mapping(Dish::getName, Collectors.joining("/", "{", "}")))).ifPresent(System.out::println);


    }

    @Test
    public void fun10() {
        // 取出最大的calorie食品
        getList().stream().collect(Collectors.maxBy(Comparator.comparingInt(Dish::getCalories))).ifPresent(System.out::println);
        // 取出最小的calorie食品
        getList().stream().collect(Collectors.minBy(Comparator.comparingInt(Dish::getCalories))).ifPresent(System.out::println);
    }


    @Test
    public void fun11() {
        Optional.of(getList().stream().collect(Collectors.summarizingInt(Dish::getCalories))).ifPresent(System.out::println);

        Optional.of(getList().stream().collect(Collectors.summarizingLong(Dish::getCalories))).ifPresent(System.out::println);

        Optional.of(getList().stream().collect(Collectors.summarizingDouble(Dish::getCalories))).ifPresent(System.out::println);


    }


    @Test
    public void fun12() {
        Optional.of(getList().stream().collect(Collectors.toCollection(LinkedHashSet::new))).ifPresent(System.out::println);
        Optional.of(getList().stream().collect(Collectors.toSet()).stream().collect(Collectors.toConcurrentMap(Dish::getName, Dish::getCalories))).ifPresent(System.out::println);
    }


    @Test
    public void fun13() {
        // 计算各类型的个数
        Optional.of(getList().stream().collect(Collectors.toMap(Dish::getType, v -> 1L, (a, b) -> a + b))).ifPresent(System.out::println);

        Optional.of(getList().stream().collect(Collectors.toMap(Dish::getType, v -> 1L, (a, b) -> a + b, ConcurrentSkipListMap::new))).ifPresent(System.out::println);

    }


    @Test
    public void fun14() {
        // 1 根据实体中的type字端分组
        Optional.ofNullable(getList().stream().collect(Collectors.groupingBy(Dish::getType))).ifPresent(this::print);

        // 2 将分组的数据1 转换成流（downStream），进行下一次复合操作
        Optional.ofNullable(getList().stream().collect(Collectors.groupingBy(Dish::getType, Collectors.averagingDouble(Dish::getCalories)))).ifPresent(this::print);

        // 将数据2转成指定的Map类型
        Optional.ofNullable(getList().stream().collect(Collectors.groupingBy(Dish::getType, TreeMap::new, Collectors.averagingDouble(Dish::getCalories)))).ifPresent(this::print);
    }


    @Test
    public void fun15() {
        // 1 根据实体中的type字端分组
        Optional.ofNullable(getList().stream().collect(Collectors.groupingByConcurrent(Dish::getType))).ifPresent(this::print);

        // 2 将分组的数据1 转换成流（downStream），进行下一次复合操作
        Optional.ofNullable(getList().stream().collect(Collectors.groupingByConcurrent(Dish::getType, Collectors.averagingDouble(Dish::getCalories)))).ifPresent(this::print);

        // 将数据2转成指定的Map类型 注意指定Map类型必须继承ConcurrentHashMap
        Optional.ofNullable(getList().stream().collect(Collectors.groupingByConcurrent(Dish::getType, ConcurrentHashMap::new, Collectors.averagingDouble(Dish::getCalories)))).ifPresent(this::print);
    }


    @Test
    public void fun16() {
        // 1 对实体进行kv映射，映射对象任选，但K不允许重复
        Optional.of(getList().stream().collect(Collectors.toMap(Dish::getName, Dish::getType))).ifPresent(this::print);
        // 2 对实体进行kv映射，允许V重复，并对V值进行合并
        Optional.of(getList().stream().collect(Collectors.toMap(Dish::getType, v -> 1L, (a, b) -> a + b))).ifPresent(this::print);
        // 3 对实体进行kv映射，允许V重复，并对V值进行合并 转换成指定的Map类型
        Optional.of(getList().stream().collect(Collectors.toMap(Dish::getType, v -> 1L, (a, b) -> a + b, TreeMap::new))).ifPresent(this::print);

    }


    @Test
    public void fun17() {
        // 1 对实体进行kv映射，映射对象任选，但K不允许重复
        Optional.of(getList().stream().collect(Collectors.toConcurrentMap(Dish::getName, Dish::getType))).ifPresent(this::print);
        // 2 对实体进行kv映射，允许V重复，并对V值进行合并
        Optional.of(getList().stream().collect(Collectors.toConcurrentMap(Dish::getType, v -> 1L, (a, b) -> a + b))).ifPresent(this::print);
        // 3 对实体进行kv映射，允许V重复，并对V值进行合并 转换成指定的Map类型
        Optional.of(getList().stream().collect(Collectors.toConcurrentMap(Dish::getType, Dish::getCalories, (a, b) -> a + b, ConcurrentSkipListMap::new))).ifPresent(this::print);
    }


    @Test
    public void fun18() {

        //对传入的数据做平均值计算
        Optional.of(getList().stream().collect(Collectors.averagingDouble(Dish::getCalories))).ifPresent(System.out::println);
        Optional.of(getList().stream().collect(Collectors.averagingInt(Dish::getCalories))).ifPresent(System.out::println);
        Optional.of(getList().stream().collect(Collectors.averagingLong(Dish::getCalories))).ifPresent(System.out::println);

        //对传入的数据做统计计算
        Optional.ofNullable(getList().stream().collect(Collectors.summingDouble(Dish::getCalories))).ifPresent(this::print);
        Optional.ofNullable(getList().stream().collect(Collectors.summingInt(Dish::getCalories))).ifPresent(this::print);
        Optional.ofNullable(getList().stream().collect(Collectors.summingLong(Dish::getCalories))).ifPresent(this::print);

        //
        Optional.of(getList().stream().map(Dish::getName).collect(Collectors.joining("/","<",">"))).ifPresent(this::print);


        getList().stream().collect(Collectors.minBy(Comparator.comparingInt(Dish::getCalories))).ifPresent(this::print);
        getList().stream().map(Dish::getCalories).collect(Collectors.minBy(Comparator.comparingDouble(Integer::intValue))).ifPresent(this::print);

    }


     @Test
     public  void fun19(){
         Optional.of(getList().stream().collect(Collectors.summarizingDouble(Dish::getCalories))).ifPresent(this::print);
     }


      @Test
      public  void fun20(){
          Optional.ofNullable(getList().stream().collect(Collectors.partitioningBy(Dish::isVegetarian))).ifPresent(this::print);

          getList().stream().map(e->1).reduce((a, b) -> a + b).ifPresent(this::print);
      }



    void print(Object s) {
        System.out.println(s.getClass());
        System.out.println(s);
    }

}
