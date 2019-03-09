package com.kk.Advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/*
       1.将切点方法中的参数传入通知中 进行处理
       2.传入的值是复制
 */
@Aspect
public class PayAdvicePram {


    @Pointcut("execution(* com.kk.Pojo.Product.checkProductStatus(String))&&args(Status) ")
    public void checkProductStatus(String Status){}


    @Before("checkProductStatus(status)")
    public void fun1(String status){
        System.out.println("执行方法前--->" + status);
        status="hh";
    }




}
