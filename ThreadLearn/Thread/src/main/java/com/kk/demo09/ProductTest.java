package com.kk.demo09;

public class ProductTest {
    public static void main(String[] args) {
        Product product = new Product();
        new Thread(() -> {while(true) product.produce();},"生产者1号").start();
        new Thread(() -> {while(true) product.produce();},"生产者2号").start();
        new Thread(() ->{while (true) product.consume();},"消费者1号").start();
        new Thread(() ->{while (true) product.consume();},"消费者2号").start();




    }
}
