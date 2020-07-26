package org.cheapter1;

public class ThreadExecute {
    public static void main(String[] args) throws InterruptedException {


        Thread.sleep(10_000);

        Thread thread = new Thread(() -> {

            Thread thread1 = new Thread(() -> {
                while(true){
                    try {
                        Thread.sleep(1_000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("hello world");
                }
            });

            thread1.setDaemon(true);

            thread1.start();

            try {
                Thread.sleep(10_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("now i am finished ");
        });


        thread.start();



    }
}
