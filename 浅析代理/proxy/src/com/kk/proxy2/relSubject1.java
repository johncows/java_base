package com.kk.proxy2;

import com.kk.proxy1.crud;

/**
 * @author kk
 * @dare 2018/8/15 - 10:48
 */
public class relSubject1 implements crud {

    public void save() {
        System.out.println("保存1");
    }


    public void find() {
        System.out.println("寻找1");
    }


    public void delete() {
        System.out.println("删除1");
    }


    public void add() {
        System.out.println("添加1");
    }
}
