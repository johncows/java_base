package com.kk.cheapter3.domain;


import lombok.Data;

@Data
public class Transaction {


    private final Trader trader;
    private final int year;
    private final int value;

    public Transaction(Trader trader, int year, int value) {
        this.trader = trader;
        this.year = year;
        this.value = value;
    }

}

