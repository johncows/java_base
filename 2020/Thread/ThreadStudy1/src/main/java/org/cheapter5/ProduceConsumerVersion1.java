package org.cheapter5;

/**
 *  单消费者 单生产情况下 正常情况
 */
public class ProduceConsumerVersion1 {

    private final Object LOCK = new Object();

    private boolean isProduced = false;

    private int productId = 0;

    public void procedure() {
        synchronized (LOCK) {
            if (isProduced) {
                try {
                    LOCK.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                productId++;
                System.out.println(Thread.currentThread().getName()+"已生产产品，编号 " + productId);
                isProduced = true;
                LOCK.notify();
            }
        }
    }


    public void consumer() {
        synchronized (LOCK) {
            // 以生产了，即消费
            if (isProduced) {
                System.out.println(Thread.currentThread().getName()+"已消费产品，编号 " + productId);
                isProduced = false;
                LOCK.notify();
            } else {
                try {
                    LOCK.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
