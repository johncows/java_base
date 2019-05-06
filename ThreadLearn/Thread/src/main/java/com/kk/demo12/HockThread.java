package com.kk.demo12;

/**
 * @author KK
 * @create 2019-05-06 21:35
 **/
public class HockThread {
    public static void main(String[] args) {

        int count = 0;

        Runtime.getRuntime().addShutdownHook(new Thread(()->{
            System.out.println("正在保存文件!!!!");
            try {
                Thread.sleep(3000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("正在退出系统!!!!");

        }));


        while (true){
            System.out.println("i am working !!!!");
            try {
                Thread.sleep(1_000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count++;
            if(count>20)
            throw new RuntimeException("超时");
        }



    }
}
