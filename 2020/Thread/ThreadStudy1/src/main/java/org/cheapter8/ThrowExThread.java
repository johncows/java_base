package org.cheapter8;

import java.util.Optional;

public class ThrowExThread {


    public static void main(String[] args) {

        fun1();

    }



    private static void fun1(){
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(5_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int i = 1 / 0;
        });


        // 利用 api 在外部捕获内部异常
        thread.setUncaughtExceptionHandler((t,e)->{
            Optional.of(t.getName()+" occur a Exception for "+ e.getMessage()).ifPresent(System.out::println);
        });
        thread.start();

    }

}
