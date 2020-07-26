package org.cheapter4;

public class OtherService {
     private final Object lock = new Object();

     private MyService myService;


    public OtherService(MyService myService) {
        this.myService = myService;
    }

    public void m1(){
        synchronized (lock){
            System.out.println("m1-------------------");
            myService.m2();
        }
    }


}
