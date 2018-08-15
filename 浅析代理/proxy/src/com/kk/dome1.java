package com.kk;

import com.kk.proxy1.Proxy1;
import com.kk.proxy1.crud;
import com.kk.proxy1.relSubject;

/**
 * @author kk
 * @dare 2018/8/15 - 10:09
 */
public class dome1 {
    public static void main(String[] args) {
        crud subject = new relSubject();
        crud proxy = new Proxy1(subject);

        proxy.add();
        proxy.delete();


    }
}
