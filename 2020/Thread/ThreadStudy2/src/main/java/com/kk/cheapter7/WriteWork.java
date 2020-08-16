package com.kk.cheapter7;

import java.util.Random;

public class WriteWork extends Thread {
    private static final Random RANDOM = new Random(System.currentTimeMillis());

    private final ShareData shareData;

    private final String filler;

    private int index = 0;

    public WriteWork(ShareData shareData, String filler) {
        this.shareData = shareData;
        this.filler = filler;
    }

    @Override
    public void run() {
        try{
            while (true){
                char c = nextChar();
                shareData.write(c);
                Thread.sleep(RANDOM.nextInt(1000));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    private char nextChar() {
        char c = filler.charAt(index);
        index++;
        if (index >= filler.length()) {
            index = 0;
        }
        return c;
    }


}
