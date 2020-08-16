package com.kk.cheapter8;

public class SyncInvoke {
    public static void main(String[] args) throws InterruptedException {
        FutureTask futureTask = ()->{
            try {
                Thread.sleep(10_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "I am Ok";
        };

        FutureService futureService = new FutureService();
        Future future = futureService.submit(futureTask,System.out::println);

        System.out.println("=====================");
        System.out.println("do other things ");
        try {
            Thread.sleep(1_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("=====================");


//        Object o = future.get();
//        System.out.println("o = " + o);



    }
}
