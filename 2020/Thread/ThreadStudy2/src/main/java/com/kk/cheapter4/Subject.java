package com.kk.cheapter4;

import java.util.ArrayList;
import java.util.List;

public class Subject {

    private List<Observer> observers = new ArrayList<>();

    private int state;

    public List<Observer> getObservers() {
        return observers;
    }

    public void attachObserver(Observer observer) {
        observers.add(observer);
    }

    public void setState(int state) {
        if (this.state != state) {
            this.state = state;
            notifyAllObserver();
        }
    }

    private void notifyAllObserver() {
        observers.forEach(Observer::update);
    }

}
