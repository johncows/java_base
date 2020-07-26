package org.cheapter4;


public class DemoTest {
    public static void main(String[] args) {
        MyService myService = new MyService();
        OtherService otherService = new OtherService(myService);
        myService.setOtherService(otherService);

        Thread thread1 = new Thread(() -> {
            while (true) {
                myService.m2();
            }
        });
        Thread thread2 = new Thread(() -> {
            while (true) {
                otherService.m1();
            }
        });


        thread1.start();
        thread2.start();
    }
}
