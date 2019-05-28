package com.kk.demo06;

/**
 * @author KK
 * @create 2019-05-24 21:13
 **/
public class User extends Thread{
    private final String name;
    private final String address;
    private final Gate gate;


    public User(String name, String address, Gate gate) {
        this.name = name;
        this.address = address;
        this.gate = gate;
    }

    @Override
    public void run() {
        System.out.println(name+"RUNNING BEGIN");
        while (true){
            gate.pass(name,address);
        }
    }
}
