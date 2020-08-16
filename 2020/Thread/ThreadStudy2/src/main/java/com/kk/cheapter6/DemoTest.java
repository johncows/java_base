package com.kk.cheapter6;

/**
 *  gong
 */
public class DemoTest {


    public static void main(String[] args) {
        Gate gate = new Gate();
        new User(gate, "baobao", "beijing").start();
        new User(gate, "guanglao", "guangzhou").start();
        new User(gate, "shanglao", "shanghai").start();


    }
}
