package com.kk.cheapter7;

import org.junit.Test;

/**
 * @author wangjunkang
 * @version 1.0
 * @description: TODO
 * @date 2020/12/2 下午7:53
 */
public class DefaultInAction {


    private void confuse(Object o){
        System.out.println("Object");
    }

    private void confuse(int[] o){
        System.out.println("int[]");
    }

    public static void main(String[] args) {
        DefaultInAction defaultInAction = new DefaultInAction();
//        what print
        defaultInAction.confuse(null);

        // 拥有更多的判断信息表明他的句柄符合Object
        int[] a = null;
        Object b = a;
        defaultInAction.confuse(b);
    }


     @Test
     public  void fun(){
        A a = ()->10;
         System.out.println(a.size());
     }

     @FunctionalInterface
    private interface A{
        int size();

         /**
          *  存在向下兼容及java8函数式编程的特点
          * @return
          */
        default  boolean isEmpty(){
            return size()==0;
        }
    }



    private interface B{
        default void hello(){
            System.out.println("hello B");
        }
    }

    private interface C {
        default void hello(){
            System.out.println("hello C");
        }
    }

    private class D implements B,C{
        @Override
        public void hello() {
            B.super.hello();
        }
    }


     @Test
     public  void fun4(){
         B d = new D(){};
         d.hello();
     }

}
