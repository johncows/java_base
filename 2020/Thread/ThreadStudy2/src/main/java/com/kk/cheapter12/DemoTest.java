package com.kk.cheapter12;

import java.util.Random;
import java.util.stream.IntStream;

public class DemoTest {

    public static void main(String[] args) {
        final SimpleCountDownLatch simpleCountDownLatch = new SimpleCountDownLatch(5);

        final Random random = new Random(System.currentTimeMillis());


        IntStream.range(0,5).forEach(e->{
            final Thread thread = new Thread(){
                @Override
                public void run() {
                    try {
                        Thread.sleep(random.nextInt(10_000));
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"的任务执行完成！！！");
                    simpleCountDownLatch.countDown();

                }
            };
            thread.start();
        });

        System.out.println("等待上述任务执行完成！！！！");

        simpleCountDownLatch.await();

        System.out.println("释放野性之力！！！！");

    }
}
