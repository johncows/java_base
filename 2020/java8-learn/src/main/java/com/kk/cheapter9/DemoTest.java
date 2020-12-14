package com.kk.cheapter9;

import org.junit.Test;

import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.util.Optional;
import java.util.OptionalInt;

/**
 * @author wangjunkang
 * @version 1.0
 * @description: TODO
 * @date 2020/12/3 下午5:42
 */
public class DemoTest {

    @Test
    public void fun1() {
        Optional.of(LocalDate.now()).ifPresent(this::print);

        OptionalInt.of(LocalDate.now().get(ChronoField.DAY_OF_MONTH)).ifPresent(this::print);
    }


    void print (Object o){
        System.out.println(o.getClass());
        System.out.println(o);
    }

}
