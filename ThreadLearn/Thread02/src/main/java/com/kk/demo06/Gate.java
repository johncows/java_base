package com.kk.demo06;


/**
 * @author KK
 * @create 2019-05-24 21:07
 **/
public class Gate {

    private int counter = 0;
    private String name = "NoBody";
    private String address = "NowWhere";


    public  void pass(String name,String address){
        this.counter++;
        this.name = name;
        this.address = address;
        verify();
    }

    public  void verify(){
        if(name.charAt(0)!=address.charAt(0)){
            System.out.println("---BROKEN---"+toString());
        }
    }

    @Override
    public String toString() {
        return "counter=" + counter +
                ", name='" + name + '\'' +
                ", address='" + address;
    }
}
