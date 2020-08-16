package com.kk.cheapter4;

public class ThreadDemo {

    public static void main(String[] args) throws InterruptedException {
        Subject subject = new Subject();

        new BinaryObserver(subject);
        new OctalObserver(subject);


        int i = 0;
        while (true) {
            Thread.sleep(3_000);
            subject.setState(i++);
        }

    }

}
