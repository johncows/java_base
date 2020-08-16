package com.kk.cheapter9;

import java.util.Optional;
import java.util.Random;

public class ServerThread extends Thread {

    private final RequestQueue queue;

    private final Random random;

    private volatile boolean flag = true;

    public ServerThread(RequestQueue queue) {
        this.queue = queue;
        this.random = new Random(System.currentTimeMillis());
    }


    public void done(){
        this.flag = false;
        this.interrupt();
    }

    @Override
    public void run() {
        while (flag) {
            Request request = queue.getRequest();
            if (request == null) {
                Optional.of("Receive a empty Request .").ifPresent(System.out::println);
                continue;
            }
            Optional.of("Receive the Request is " + request.getValue()).ifPresent(System.out::println);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
