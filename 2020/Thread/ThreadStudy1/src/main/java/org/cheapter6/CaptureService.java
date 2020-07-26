package org.cheapter6;

import javax.naming.ldap.Control;
import java.lang.reflect.Array;
import java.util.*;

public class CaptureService {

    private static final LinkedList<Control> CONTROLS = new LinkedList<>();

    public static void main(String[] args) {
        List<Thread> works = new ArrayList<>();

        Arrays.asList("M1", "M2", "M3", "M4", "M5", "M6", "M7", "M8", "M9", "M10").stream().map(CaptureService::createCaptureThread).forEach(
                e -> {
                    e.start();
                    works.add(e);
                }
        );


        works.forEach(e->{
            try {
                e.join();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        });
        Optional.of("ALL Capture task has been finished ").ifPresent(System.out::println);
    }


    private static Thread createCaptureThread(String name) {
        return new Thread(() -> {
            Optional.of("The worker  [" + Thread.currentThread().getName() + "] begin capture Machine Info").ifPresent(System.out::println);

            synchronized (CONTROLS) {
                Control control = new Control();
                while (CONTROLS.size() > 5) {
                    // 运行的线程超过 5
                    try {
                        CONTROLS.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                CONTROLS.addLast(control);
            }


            Optional.of("The worker  [" + Thread.currentThread().getName() + "]  capture Machine Info now").ifPresent(System.out::println);


            try {
                Thread.sleep(10000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            synchronized (CONTROLS) {
                Optional.of("The worker  [" + Thread.currentThread().getName() + "]  capture Machine Info over").ifPresent(System.out::println);
                CONTROLS.removeFirst();
                CONTROLS.notifyAll();
            }
        }, name);
    }

    private static class Control {

    }


}
