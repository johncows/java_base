package com.kk.demo06;

public class TicketServer02 implements Runnable {

    private static final int MAX = 60;

    private Integer index = 1;


    @Override
    public synchronized void run() {
        while (true) {
            if (index <= MAX) {
                try {
                    Thread.sleep(1_00);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "=>" + index++);
            } else {
                break;
            }
        }
    }
}
