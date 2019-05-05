package com.kk.demo09;

public class ProductTest {
    public static void main(String[] args) {
        Product02 product = new Product02();
        new Thread(() -> {while(true){ product.produce();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }},"生产者1号").start();
        new Thread(() -> {while(true){ product.produce();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }},"生产者1号").start();new Thread(() -> {while(true){ product.produce();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }},"生产者1号").start();new Thread(() -> {while(true){ product.consume();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }},"生产者1号").start();

        new Thread(() -> {while(true){ product.consume();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }},"消费者1号").start();




//      new Thread(() ->{while (true) product.consume();},"消费者2号").start();




    }
}
