package com.kk.cheapter9;

public class DemoTest {
    public static void main(String[] args) {
        RequestQueue requestQueue = new RequestQueue();
        new ClientThread(requestQueue).start();
        new ServerThread(requestQueue).start();
    }
}
