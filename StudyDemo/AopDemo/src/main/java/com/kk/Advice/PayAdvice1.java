package com.kk.Advice;

import org.aspectj.lang.annotation.*;

//切点

/*
    方法一: 通过切点来选择连接点
    利用注解AspectJ语法来选择连接点
 */
@Aspect
public class PayAdvice1 {

    /*
        举例
         @Before("execution(* com.kk.Pojo.Product.buyProduct(..))")
          行为    方法执行时 返回值   包名 方法名 参数名(.. 表示*)
     */


    @Before("execution(* com.kk.Pojo.Product.buyProduct(..))")
    public void beforePay() {
        System.out.println("查看你的金额 十元");
    }

    public void inPay() {
        System.out.println("需要支付五元 正在支付中");
    }

    @AfterReturning("execution(* com.kk.Pojo.Product.buyProduct(..))")
    public void successPay() {
        System.out.println("支付完成 还剩五元");
    }

    @AfterThrowing("execution(* com.kk.Pojo.Product.buyProduct(..))")
    public void errorPay() {
        System.out.println("请充值");
    }

    @After("execution(* com.kk.Pojo.Product.buyProduct(..))")
    public void afterPay() {
        System.out.println("交易结束");
    }


}
