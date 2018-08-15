package com.kk.proxy1;

/**
 * @author kk
 * @dare 2018/8/15 - 10:05
 */
public class Proxy1 implements crud {

    private crud subject;

    public Proxy1(crud subject) {
        this.subject = subject;
    }

    @Override
    public void save() {
        System.out.println("前面事务");
        subject.save();
        System.out.println("后面事务");
    }

    @Override
    public void find() {
        System.out.println("前面事务");
        subject.find();
        System.out.println("后面事务");
    }

    @Override
    public void delete() {
        System.out.println("前面事务");
        subject.delete();
        System.out.println("后面事务");
    }

    @Override
    public void add() {
        System.out.println("前面事务");
        subject.add();
        System.out.println("后面事务");
    }
}
