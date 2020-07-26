package org.cheapter5;

/**
 *  多线程情况下添加notifyall方法
 */
public class ProduceConsumerVersion2 {

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
                LOCK.notifyAll();
            }
        }
    }


    public void consumer() {
        synchronized (LOCK) {
            // 以生产了，即消费
            if (isProduced) {
                System.out.println(Thread.currentThread().getName()+"已消费产品，编号 " + productId+"--");
                isProduced = false;
                LOCK.notifyAll();
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
