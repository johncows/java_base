package com.kk.proxy1;

/**
 * @author kk
 * @dare 2018/8/15 - 10:03
 */
public class relSubject implements crud{
    @Override
    public void save() {
        System.out.println("保存");
    }

    @Override
    public void find() {
        System.out.println("寻找");
    }

    @Override
    public void delete() {
        System.out.println("删除");
    }

    @Override
    public void add() {
        System.out.println("添加");
    }
}
