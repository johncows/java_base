package com.kk.demo04.version1;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author KK
 * @create 2019-05-22 21:08
 **/


@Data
public class Secretary {

    private List<StockObserver> observers = new ArrayList<>();
    private String action;
    private String secretaryStatus;


    public void attach(StockObserver stockObserver){
        observers.add(stockObserver);
    }

    public void notifyAllStockObserver(){
        observers.forEach(e->e.update());
    }




}
