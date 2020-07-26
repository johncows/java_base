package com.kk.Exception;

public class MyException extends RuntimeException {
    public MyException(String message) {
        super(message);
        System.out.println("这是一个自定义的运行时异常");
    }
}
