package org.cheapter9;

import java.util.Arrays;
import java.util.Optional;

public class A {
    public static void doSth(){
      Arrays.asList(Thread.currentThread().getStackTrace()).stream().filter(e->true)
      .forEach(e-> Optional.of(e.getClassName()+"--"+e.getMethodName()+"--"+e.getLineNumber()).ifPresent(System.out::println));
    }
}
