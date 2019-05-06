package com.kk.demo13;

/**
 * @author KK
 * @create 2019-05-06 22:39
 **/
public class GroupThread01 {

    public static void main(String[] args) throws InterruptedException {

        ThreadGroup tg1 = new ThreadGroup("tg1");
        
        new Thread(tg1,()->{
            try {
                Thread.sleep(15_000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        tg1.setDaemon(false);
        Thread.sleep(17_000);
        
        tg1.destroy();

        System.out.println("tg1.isDestroyed() = " + tg1.isDestroyed());

    }    
    
}
