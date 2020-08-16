package com.kk.cheapter6;

public class User extends Thread {


    private final Gate gate;

    private final String myUserName;

    private final String myAddress;


    public User(Gate gate, String myUserName, String myAddress) {
        this.gate = gate;
        this.myUserName = myUserName;
        this.myAddress = myAddress;
    }

    @Override
    public void  run() {
        while (true){
            gate.pass(this.myUserName,this.myAddress);
        }
    }
}
