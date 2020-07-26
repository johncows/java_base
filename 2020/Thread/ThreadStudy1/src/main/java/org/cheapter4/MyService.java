package org.cheapter4;

public class MyService {
    private final Object lock = new Object();

    private OtherService otherService;

    public void setOtherService(OtherService otherService) {
        this.otherService = otherService;
    }

    public void m2() {
        synchronized (lock) {
            System.out.println("m2-----------------");
            otherService.m1();
        }
    }
}