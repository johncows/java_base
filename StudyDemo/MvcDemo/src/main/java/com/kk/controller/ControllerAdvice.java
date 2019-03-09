package com.kk.controller;


import org.springframework.web.bind.annotation.ExceptionHandler;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(Exception2.class)
    public String fun1(){
        System.out.println("异常通知处理");
        return "error";
    }


}
