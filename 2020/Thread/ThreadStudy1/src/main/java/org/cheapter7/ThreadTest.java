package org.cheapter7;

import java.util.Optional;
import java.util.stream.Stream;

public class ThreadTest {

    public static void main(String[] args) {
        fun1();
    }



     public static void fun1(){

         BooleanLock booleanLock = new BooleanLock(false);


         Optional.of(Thread.currentThread().getName()+" is working now ----").ifPresent(System.out::println);

         Stream.of("T1","T2","T3","T4").forEach(e->{
             new Thread(()->{
                 try {
                     booleanLock.lock(3000L);
                     Optional.of(Thread.currentThread().getName()+" get the lock, working now ").ifPresent(System.out::println);
                     Thread.sleep(10000L);
                 } catch (InterruptedException |TimeOutException ex) {
                     ex.printStackTrace();
                 }finally {
                     booleanLock.unlock();
                 }
             },e).start();

         });


     }

}
