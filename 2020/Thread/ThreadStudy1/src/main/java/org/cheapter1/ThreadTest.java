package org.cheapter1;

public class ThreadTest {
    public static void main(String[] args) throws InterruptedException {
        ThreadService threadService = new ThreadService();


        long start = System.currentTimeMillis();


        threadService.execute(()->{
            while (true){
                // 一个非常耗时的操作
                System.out.println("loading ------");;
            }
        });

        threadService.shutdown(3_000);

        long end = System.currentTimeMillis();

        System.out.println("已经耗时" + (end - start));


        Thread.sleep(10000L);

    }
}
