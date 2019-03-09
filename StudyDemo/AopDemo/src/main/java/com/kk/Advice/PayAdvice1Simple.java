package com.kk.Advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/*
       由于切点表达式重复 为了简化 可以定义命名切点
 */
@Aspect
public class PayAdvice1Simple {


    @Pointcut("execution(* com.kk.Pojo.Product.buyProduct(..))")
    public void byProduct(){}


    @Around("byProduct()")
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




    @Before("byProduct()")
    public void beforePay(){
        System.out.println("查看你的金额 十元");
    }

    public void inPay(){
        System.out.println("需要支付五元 正在支付中");
    }

    @AfterReturning("byProduct()")
    public void successPay(){
        System.out.println("支付完成 还剩五元");
    }

    @AfterThrowing("byProduct()")
    public void errorPay(){
        System.out.println("请充值");
    }

    @After("byProduct()")
    public  void afterPay(){
        System.out.println("交易结束");
    }



}
