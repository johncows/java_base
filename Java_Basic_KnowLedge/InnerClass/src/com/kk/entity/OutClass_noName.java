package com.kk.entity;

import com.kk.entity.noName.InnerClassForInterface;

public class OutClass_noName {

    private  String describe="外部私有变量";

    public InnerClassForInterface getInnerClass(final int num, String str2){
        return new InnerClassForInterface(){
            int number = num + 3;
            public int getNum(){
                System.out.println("str2 = " + str2);
                return number;
            }
        };
    }


}
