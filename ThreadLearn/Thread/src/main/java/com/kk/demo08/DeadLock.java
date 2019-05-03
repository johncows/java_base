package com.kk.demo08;


import java.io.ObjectOutput;

public class DeadLock {

    private OtherService otherService;

    private final Object LOCK = new Object();

    public DeadLock(OtherService otherService){
        this.otherService = otherService;
    }

    public void m1(){
        synchronized (LOCK){
            System.out.println("m1方法执行中-------");
        }
    }

    public void m2(){
        synchronized (LOCK){
            System.out.println("m2方法执行中-------");
            otherService.s1();
        }
    }










}
