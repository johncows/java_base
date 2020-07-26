package org.cheapter2;

public class TicketMachine implements Runnable {

    private static Integer ticketNum = 5000;


    @Override
    public void run() {
        task();
    }

     public  synchronized void task(){
         while (true) {
             if (ticketNum <= 0) {
                 break;
             }
             try {
                 Thread.sleep(5);
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
             System.out.printf("%s 派发出一张票，该票的号码是 %s \n", Thread.currentThread().getName(), ticketNum--);
         }
     }

}
