package com.kk.entity;
/*
        局部内部类 定义在方法中的内部类。



        注意：

        1、内部类不能被public、private、static修饰；
        2、在外部类中不能创建内部类的实例；
        3、创建内部类的实例只能在包含他的方法中；
        4、内部类访问包含他的方法中的变量必须有final修饰；
        5、外部类不能访问局部内部类，只能在方法体中访问局部内部类，且访问必须在内部类定义之后。

        6.内部类可以去访问直接访问外部参数 自己方法中参数必须以final修饰

        具体代码块见 demo1.OutClass_part
 */

public class OutClass_part {

    private String Out_describe="我是一个外部类";

    public void Method(){
        System.out.println("Out_describe = " + Out_describe);
    }

    public void Out_Method(){
         final String method_describe="我是一个外部类方法";


         class Inner_Class{
             String inner_describe="我是一个内部类参数";
            public void speck(){
                System.out.println("Out_describe = " + Out_describe);
                System.out.println("method_describe = " + method_describe);
                System.out.println("inner_describe = " + inner_describe);
            }
         }

          Inner_Class inner_class = new Inner_Class();
         inner_class.speck();

    }



}
