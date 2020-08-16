package com.kk.cheapter9;

import java.util.Random;
import java.util.stream.IntStream;

public class ClientThread  extends Thread{

    private final RequestQueue requestQueue;

    private final Random random;


    public ClientThread(RequestQueue requestQueue) {
        this.requestQueue = requestQueue;
        this.random = new Random(System.currentTimeMillis());
    }


    @Override
    public void run() {
        IntStream.range(0,20).forEach(e->{
            System.out.println("Client -> request " + e);
            requestQueue.putRequest(new Request(e+""));
            try {
                Thread.sleep(random.nextInt(600));
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        });
    }
}
