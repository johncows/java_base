package com.kk.demo;


import com.kk.entity.OutClass_Static;
import com.kk.entity.OutClass_noName;
import com.kk.entity.OutClass_ordinary;
import com.kk.entity.OutClass_part;
import com.kk.entity.noName.InnerClassForInterface;
import org.junit.Test;

public class demo1 {


    @Test
    public void OutClass_ordinary(){
        OutClass_ordinary outClass_ordinary = new OutClass_ordinary();
        outClass_ordinary.speck();
        OutClass_ordinary.InnerClass innerClass = outClass_ordinary.new InnerClass();
        String name = innerClass.getName();
        System.out.println("name = " + name);
    }

    @Test
    public void OutClass_part(){
        OutClass_part outClass_part = new OutClass_part();
        outClass_part.Out_Method();
    }


    @Test
    public void OutClass_noName(){
        OutClass_noName outClass_noName = new OutClass_noName();
        InnerClassForInterface innerClass = outClass_noName.getInnerClass(1,"hello");
        int num = innerClass.getNum();
        System.out.println("num = " + num);
    }


    @Test
    public void OutClass_Static(){
        OutClass_Static.innerClass innerClass = new OutClass_Static.innerClass();
        innerClass.method_inner();
    }





}
