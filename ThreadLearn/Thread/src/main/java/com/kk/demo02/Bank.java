package com.kk.demo02;

public class Bank {


    public static void main(String[] args) {

        final TicketWindow ticketWindow = new TicketWindow();
        Thread thread01 = new Thread(ticketWindow, "1号窗口");
        Thread thread02 = new Thread(ticketWindow, "2号窗口");
        Thread thread03 = new Thread(ticketWindow, "3号窗口");


        new Thread(()->
            System.out.println("thread03 = " + thread03)
        ,"hello");



        thread01.start();
        thread02.start();
        thread03.start();


    }
}