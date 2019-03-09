package com.kk.Advice.NoAnnotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

public class PayAdviceSimple {


    public void byProduct(){}


    public void around(ProceedingJoinPoint joinPoint){
        try {
            System.out.println("方法执行前");
            joinPoint.proceed();
            System.out.println("方法正确执行后");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            System.out.println("方法异常执行后");
        }
        System.out.println("方法执行后");
    }


}
