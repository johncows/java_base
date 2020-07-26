package org.cheapter2;


public class ThreadTest {

    public static void main(String[] args) {
        Thread t1 = new Thread(new TicketMachine(), "一号机");
        Thread t2 = new Thread(new TicketMachine(), "二号机");
        Thread t3 = new Thread(new TicketMachine(), "三号机");
        t1.start();
        t2.start();
        t3.start();
    }


}
