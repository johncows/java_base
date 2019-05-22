package com.kk.demo04.version2;


import java.util.ArrayList;
import java.util.List;

/**
 * @author KK
 * @create 2019-05-22 21:46
 **/
public class Boss implements Subject {

    private List<Observer> observers = new ArrayList<>();

    private String currentStatus = "无事情发生";


    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public String  getCurrentStatus() {
        return currentStatus;
    }

    @Override
    public void setCurrentStatus(String currentStatus) {
        this.currentStatus = currentStatus;
        notifyObserver();
    }

    @Override
    public void notifyObserver() {
        observers.forEach(e->e.update());
    }
}
