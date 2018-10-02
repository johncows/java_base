package com.kk.entity;

import javax.naming.Name;

public class OutClass_Static {


    private String name="外部属性";

    public static class innerClass{
        String describe = "内部属性";
        public void  method_inner(){
            System.out.println("describe = " + describe);
//            System.out.println("name = " + name); 无法访问 也就是说丧失了关联性!!
         }


    }





}
