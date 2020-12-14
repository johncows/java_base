package com.kk.cheapter11;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.OptionalInt;

/**
 * @author wangjunkang
 * @version 1.0
 * @description: LocalDate 使用方式
 * @date 2020/12/14 下午7:12
 */
public class LocalDateTest {

    @Test
    public void fun1() {
        // 线程安全
        Optional.of(LocalDate.now()).ifPresent(System.out::println);

        Optional.of(LocalDate.now().getYear()).ifPresent(System.out::println);
        Optional.of(LocalDate.now().getMonth()).ifPresent(System.out::println);
        Optional.of(LocalDate.now().getDayOfMonth()).ifPresent(System.out::println);
        Optional.of(LocalDate.now().getChronology()).ifPresent(System.out::println);
        Optional.of(LocalDate.now().getYear()).ifPresent(System.out::println);

    }

     @Test
     public  void fun2(){
         OptionalInt.of(LocalTime.now().getHour()).ifPresent(System.out::println);
         Optional.of(LocalDateTime.of(LocalDate.now(), LocalTime.now())).ifPresent(System.out::println);
     }


    // 传统的date方式的弊端及sdf的线程错误 mutipo point



     @Test
     public  void fun3() throws InterruptedException {
         Optional.ofNullable(Instant.now()).ifPresent(System.out::println);
         Thread.sleep(1000L);
         Optional.ofNullable(Instant.now()).ifPresent(System.out::println);
     }

      @Test
      public  void fun4() throws InterruptedException {
          Instant start = Instant.now();

          Thread.sleep(1000L);

          Instant end = Instant.now();

          long l = Duration.between(start, end).toNanos();

          System.out.println("l = " + l);
      }


       @Test
       public  void fun5(){
           int days = Period.ofDays(1).getDays();
           System.out.println("days = " + days);
       }


        @Test
        public  void fun6(){
            LocalDate localDate = LocalDate.now();
            Optional.of(localDate.format(DateTimeFormatter.BASIC_ISO_DATE)).ifPresent(System.out::println);
            Optional.of(localDate.format(DateTimeFormatter.ISO_LOCAL_DATE)).ifPresent(System.out::println);
        }


         @Test
         public  void fun7(){
            String dateForStr = "20201128";
             LocalDate parse = LocalDate.parse(dateForStr, DateTimeFormatter.BASIC_ISO_DATE);
             System.out.println("parse = " + parse);
         }


}

