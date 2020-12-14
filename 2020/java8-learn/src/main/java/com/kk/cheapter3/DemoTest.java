package com.kk.cheapter3;

import com.kk.cheapter2.domain.Dish;
import com.kk.cheapter3.domain.*;
import com.sun.java.accessibility.util.Translator;
import javafx.beans.property.ObjectProperty;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author wangjunkang
 * @version 1.0
 * @description: TODO
 * @date 11/26/20 6:16 PM
 */
public class DemoTest {

    List<Transaction> getList() {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");
        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );
        return transactions;
    }


    @Test
    public void fun1() {
        // 找出2011年所有交易并排序
        getList().stream().filter(transaction -> 2011 == transaction.getYear())
                .sorted(Comparator.comparingInt(Transaction::getValue)).forEach(System.out::println);
    }

    @Test
    public void fun2() {
        // 获取业务员所在的城市
        getList().stream().map(Transaction::getTrader).map(Trader::getCity).distinct().forEach(System.out::println);
    }

    @Test
    public void fun3() {
        // 筛选剑桥业务员，并排序
        getList().stream()
                .map(Transaction::getTrader)
                .distinct()
                .filter(trader -> "Cambridge".equals(trader.getCity()))
                .sorted(Comparator.comparing(Trader::getName))
                .forEach(System.out::println);
    }


    @Test
    public void fun4() {
        // 获取所有业务员名称，排序，并组合
        Optional<String> reduce = getList().stream().map(Transaction::getTrader).map(Trader::getName).sorted()
                .reduce((a, b) -> a + b);
        System.out.println("reduce = " + reduce.get());
    }

    @Test
    public void fun5() {
        // 业务员在米兰有人吗
        boolean match = getList().stream().anyMatch(e -> "Milan".equals(e.getTrader().getCity()));
        System.out.println("match = " + match);
    }


    @Test
    public void fun6() {
        Optional<Integer> reduce = getList().stream().map(Transaction::getValue).reduce(Integer::min);
        System.out.println(reduce.get());
    }


    @Test
    public void fun7() {
        // 利用INtStream来完成统计
        int sum = getList().stream().mapToInt(Transaction::getValue).sum();
        System.out.println("sum = " + sum);
    }


    @Test
    public void fun8() {
        // 自动拆箱+装箱
        IntStream intStream = getList().stream().mapToInt(Transaction::getValue);
        Stream<Integer> boxed = intStream.boxed();
    }


    @Test
    public void fun9() {
        Optional<Insurance> optionalInsurance = Optional.<Insurance>empty();

//           optionalInsurance.get();


        Optional<Insurance> optionalInsurance1 = Optional.of(new Insurance());
        Insurance insurance = optionalInsurance1.get();
    }


    @Test
    public void fun10() {
        // 该值非空 包装类不报错
        Optional<Car> optionalCar1 = Optional.of(new Car());

        // null值 抛出空指针异常
        Optional<Car> optionalCar2 = Optional.of(null);

//            // 该构造方法 允许空指针注入
        Optional<Car> optionalCar3 = Optional.ofNullable(null);

        optionalCar3.orElseGet(() -> new Car());
        optionalCar3.orElse(new Car());
    }


    @Test
    public void fun11() {
        Person person = new Person();
        Optional<Person> personOptional = Optional.of(person);
        String name = personOptional
                .map(Person::getCar)
                .map(Car::getInsurance)
                .map(Insurance::getName).orElse("UNKNOWN");
        System.out.println("name.get() = " + name);
    }

    @Test
    public void fun12() {
        Optional<Car> optional = Optional.of(new Car());

        // 即使有值，如果filter为false，依然为empty
        Car car = optional.filter(e -> {
            System.out.println("画几道鱼鳃");
            return false;
        }).get();

        System.out.println(car);

    }


     @Test
     public  void fun13(){
         Optional<Car> optional = Optional.of(new Car());
         Optional<Insurance> optionalInsurance = optional.map(Car::getInsurance);
         // Optional类中map转换，依然是Optional
         System.out.println(optionalInsurance.get());
     }


}

