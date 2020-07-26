package org.cheapter5;

import java.util.stream.Stream;

public class DemoTest {

    public static void main(String[] args) {
        fun3();
    }


    /**
     * 单一线程下的生产消费操作
     */
    public static void fun1() {
        ProduceConsumerVersion1 produceConsumerVersion1 = new ProduceConsumerVersion1();

        new Thread(() -> {
            while (true) {
                produceConsumerVersion1.consumer();
            }
        }).start();

        new Thread(() -> {
            while (true) {
                produceConsumerVersion1.procedure();
            }
        }).start();
    }

    /**
     * 多线程下的生产消费操作（错误）
     */
    public static void fun2() {
        ProduceConsumerVersion1 produceConsumerVersion1 = new ProduceConsumerVersion1();

        Stream.of("P1", "P2").forEach(e -> new Thread() {
            @Override
            public void run() {
                while (true) {
                    produceConsumerVersion1.procedure();
                }
            }
        }.start());

        Stream.of("C1", "C2").forEach(e -> new Thread() {
            @Override
            public void run() {
                while (true) {
                    produceConsumerVersion1.consumer();
                }
            }
        }.start());
    }

    /**
     * 多线程下的生产消费操作（将notify改成notifyall）
     */
    public static void fun3() {
        ProduceConsumerVersion2 produceConsumerVersion1 = new ProduceConsumerVersion2();

        Stream.of("P1", "P2", "P3", "P4").forEach(e -> new Thread() {
            @Override
            public void run() {
                while (true) {
                    produceConsumerVersion1.procedure();
                }
            }
        }.start());

        Stream.of("C1", "C2", "C3", "C4").forEach(e -> new Thread() {
            @Override
            public void run() {
                while (true) {
                    produceConsumerVersion1.consumer();
                }
            }
        }.start());
    }

}
