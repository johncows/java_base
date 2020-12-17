package com.kk.cheapter11;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Date;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.OptionalLong;
import java.util.stream.IntStream;

/**
 * @author wangjunkang
 * @version 1.0
 * @description: LocalDate 使用方式
 * @date 2020/12/14 下午7:12
 */
public class LocalDateTest {


    /**
     * @Description: jdk 1.8前的date存在以下问题
     * 1. date 语意是日期，但查询出来 日期+时间;存在含义不清晰；搭配的api较少
     * 2. dateformat 常用的格式化类有可能存在线程安全异常
     * @Param: 
     * @return: 
     * @Author: wjk
     * @Date: 2020/12/17
     */     
    @Test
    public void badExample() throws InterruptedException {
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-mm-dd");


        IntStream.range(0, 10).forEach(i ->
                new Thread(() -> {
                    for (; ; ) {
                        String format = sdf.format(new Date());
                        System.out.println(Thread.currentThread() + format);
                    }
                }).start()
        );


        Thread.sleep(1000_000);


    }


    @Test
    public void testLocalDate() {
        Optional.of(LocalDate.now()).ifPresent(System.out::println);
        Optional.of(LocalDate.now().getYear()).ifPresent(System.out::println);
        Optional.of(LocalDate.now().getMonth()).ifPresent(System.out::println);
        Optional.of(LocalDate.now().getDayOfMonth()).ifPresent(System.out::println);
        Optional.of(LocalDate.now().getChronology()).ifPresent(System.out::println);
        Optional.of(LocalDate.now().getYear()).ifPresent(System.out::println);
    }

    @Test
    public void testLocalTime() {
        OptionalInt.of(LocalTime.now().getHour()).ifPresent(System.out::println);
        OptionalInt.of(LocalTime.now().getMinute()).ifPresent(System.out::println);
        OptionalInt.of(LocalTime.now().getSecond()).ifPresent(System.out::println);
    }


    @Test
    public void testLocalDateTime() {
        OptionalInt.of(LocalDateTime.now().get(ChronoField.DAY_OF_MONTH)).ifPresent(System.out::println);
        Optional.of(LocalDateTime.of(LocalDate.now(), LocalTime.now())).ifPresent(System.out::println);
    }


    /**
     * @Description: instant 表示是某个时间点，duration 表示2个时间点的时间段
     * @Param:
     * @return:
     * @Author: wjk
     * @Date: 2020/12/17
     */
    @Test
    public void testInstanceAndDuration() throws InterruptedException {

        Optional.ofNullable(Instant.now()).ifPresent(System.out::println);
        Thread.sleep(1000L);
        Optional.ofNullable(Instant.now()).ifPresent(System.out::println);

        Instant start = Instant.now();
        Thread.sleep(1000L);
        Instant end = Instant.now();

        OptionalLong.of(Duration.between(start, end).getSeconds()).ifPresent(System.out::println);
    }


    /**
     * @Description: Period 纪元 使用方式
     * @Param:
     * @return:
     * @Author: wjk
     * @Date: 2020/12/17
     */
    @Test
    public void testPeriod() {
        LocalDate birthday = LocalDate.of(1996, 11, 28);
        OptionalInt.of(Period.between(birthday, LocalDate.now()).getDays()).ifPresent(System.out::println);
    }


    /**
     * @Description: 格式化日期参数
     * @Param:
     * @return:
     * @Author: wjk
     * @Date: 2020/12/17
     */
    @Test
    public void dateFormat() {
        LocalDate localDate = LocalDate.now();
        Optional.of(localDate.format(DateTimeFormatter.BASIC_ISO_DATE)).ifPresent(System.out::println);
        Optional.of(localDate.format(DateTimeFormatter.ISO_LOCAL_DATE)).ifPresent(System.out::println);
    }


    /**
     * @Description: 对日期参数做解析
     * @Param:
     * @return:
     * @Author: wjk
     * @Date: 2020/12/17
     */
    @Test
    public void dateParse() {
        String dateForStr = "20201128";
        LocalDate parse = LocalDate.parse(dateForStr, DateTimeFormatter.BASIC_ISO_DATE);
        System.out.println("parse = " + parse);
    }
}

