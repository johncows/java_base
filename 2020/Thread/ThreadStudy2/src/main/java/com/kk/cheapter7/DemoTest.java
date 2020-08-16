package com.kk.cheapter7;

import java.util.Arrays;

public class DemoTest {

    public static void main(String[] args) {
        ShareData shareData = new ShareData(10);
        new ReadWork(shareData).start();
        new ReadWork(shareData).start();
        new ReadWork(shareData).start();
        new ReadWork(shareData).start();
        new ReadWork(shareData).start();
        new ReadWork(shareData).start();

        new WriteWork(shareData,"HelloWorld").start();
        new WriteWork(shareData,"HelloWorld").start();
    }

}
