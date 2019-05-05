package com.kk.demo11;


import java.util.Collection;

public interface MyLock {


    void lock() throws InterruptedException;

    void lock(long mills) throws InterruptedException,TimeoutException;

    void unLock();

    Collection<Thread> getBlockThread();

     class TimeoutException extends Exception{

         public TimeoutException(String message) {
             super(message);
         }

     }

}
