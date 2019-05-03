package com.kk.demo05.force;

import sun.awt.windows.ThemeReader;

public class DemoTest {

    public static void main(String[] args) {

        ThreadServer threadServer = new ThreadServer();
        threadServer.execute(()->{
                while (true);
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        threadServer.stopThread(5_000);

    }
}
