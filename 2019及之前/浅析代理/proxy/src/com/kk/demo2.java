package com.kk;

import com.kk.proxy1.crud;
import com.kk.proxy2.proxy2;
import com.kk.proxy2.relSubject1;
import com.kk.proxy2.relSubject2;

/**
 * @author kk
 * @dare 2018/8/15 - 10:48
 */
public class demo2 {
    public static void main(String[] args) {
        relSubject1 subject1 = new relSubject1();
        relSubject2 relsubject2 = new relSubject2();

        proxy2 proxy2 = new proxy2();
        proxy2.setFactory(subject1);
        crud o = (crud)proxy2.getproxyInstance();
        o.delete();

    }
}
