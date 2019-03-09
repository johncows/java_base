package com.kk.Advice.NoAnnotation;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/*
       1.将切点方法中的参数传入通知中 进行处理
       2.传入的值是复制
 */

public class PayAdvicePram {




    public void fun1(String status){
        System.out.println("执行方法前--->" + status);
        status="hh";
    }


}
