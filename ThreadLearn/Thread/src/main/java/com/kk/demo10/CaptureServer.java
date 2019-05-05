package com.kk.demo10;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CaptureServer {

    private final static LinkedList<Control> CONTROLS = new LinkedList<>();
    private final static int MAXTHREAD= 5;

    public static void main(String[] args) {
        List<Thread> workThread =  new ArrayList<>();
        Arrays.asList("M1","M2","M3","M4","M5","M6","M7","M8","M9","M10").stream()
        .map(CaptureServer::createCaptureThread).forEach(t->{t.start();workThread.add(t);});
        workThread.stream().forEach(t->{
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }

    private static Thread createCaptureThread(String name){
        return new Thread(()->{
            synchronized (CONTROLS){
                while(CONTROLS.size()+1>MAXTHREAD){
                    try {
                        CONTROLS.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    Thread.sleep(10000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                CONTROLS.add(new Control());
            }

            /**
             *  工作代码 不同的pc上采集信息 具备并行化
             */
            System.out.println(Thread.currentThread().getName()+" is working ...");
            try {
                Thread.sleep(10_000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            synchronized (CONTROLS){
                CONTROLS.removeFirst();
                System.out.println(Thread.currentThread().getName()+" is ending ...");
                CONTROLS.notifyAll();
            }


        },name);
    }



    private static class Control{

    }


}
