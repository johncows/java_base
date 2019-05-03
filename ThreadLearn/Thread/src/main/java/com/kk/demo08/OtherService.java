package com.kk.demo08;


public class OtherService {

  private DeadLock deadLock;

  private final Object lock = new Object();

    public void setDeadLock(DeadLock deadLock) {
        this.deadLock = deadLock;
    }

    public void s1(){
        synchronized (lock){
            System.out.println("s1方法执行中========");
        }
    }

    public void s2(){
        synchronized (lock){
            System.out.println("s2方法执行中========");
            deadLock.m1();
        }
    }



}
