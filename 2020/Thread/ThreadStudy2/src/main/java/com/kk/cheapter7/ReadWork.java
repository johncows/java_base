package com.kk.cheapter7;

import java.util.Arrays;

public class ReadWork extends Thread {
    private final ShareData shareData;

    public ReadWork(ShareData shareData) {
        this.shareData = shareData;
    }


    @Override
    public void run() {
        try {
            while (true) {
                char[] read = shareData.read();
                System.out.println(Thread.currentThread().getName() + " read " + Arrays.toString(read));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
