package com.kk.entity;

//实现普通的成员内部类

/*
     内部类可以直接访问外部类的参 但外部类获取内部类的参数 必须有相应的实例化方法

     内部类要想访问外部类 直接使用相应的属性名
     外部类想访问内部类 2种方法
        1.先实例化外部类对象 再通过外部类.new 来创建内部类进行访问(非外部类中)
        2.在外部类中某个代码块中实例化内部类,根据相应属性访问(外部类中)
    具体代码块见 demo1.OutClass_ordinary
 */


public class OutClass_ordinary{
    private   String describe="我是外部类的私有属性";


    public  class InnerClass{
        private  String name="内部属性";
        public void speak(){
            System.out.println("describe = " + describe);
            System.out.println("name = " + name);
        }

        public String  getName(){
            return name;
        }
    }

    public void speck(){
        InnerClass innerClass = new InnerClass();
        String name = innerClass.getName();
        System.out.println("name = " + name);
    }


}
