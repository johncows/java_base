package com.kk.demo06;

public class DemoTest {
    public static void main(String[] args) {
        TicketServer03 ticketServer = new TicketServer03();

        Thread thread01 = new Thread(ticketServer, "1号柜台");
        Thread thread02 = new Thread(ticketServer, "2号柜台");
        Thread thread03 = new Thread(ticketServer, "3号柜台");

        thread01.start();
        thread02.start();
        thread03.start();



    }
}
