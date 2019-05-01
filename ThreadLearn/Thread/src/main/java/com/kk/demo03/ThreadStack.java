package com.kk.demo03;

public class ThreadStack {

    private static int count=0;

    public static void main(String[] args) {
        try {
            add(1);
        }
        catch (Error e){
            e.printStackTrace();
            System.out.println("count = " + count);
        }

    }

    public static void add(int i){
        count++;
        add(i+1);
    }


}
