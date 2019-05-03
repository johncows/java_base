package com.kk.demo06;

import com.sun.corba.se.spi.transport.ReadTimeouts;

public class TicketServer03 implements Runnable {

    private static final int MAX = 60;

    private Integer index = 1;


    @Override
    public  void run() {
        while (true) {
           if(fun1())
               break;
        }
    }



    private synchronized boolean fun1(){
        if (index <= MAX) {
            System.out.println(Thread.currentThread().getName()+"=>"+index++);
            return false;
        }else
        {
            return true;
        }
    }

}
