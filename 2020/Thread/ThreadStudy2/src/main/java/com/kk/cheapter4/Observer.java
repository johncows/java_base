package com.kk.cheapter4;

public abstract class Observer {

    protected Subject subject;

    public Observer(Subject subject) {
        this.subject = subject;
        subject.attachObserver(this);
    }

    public abstract void update();

}
