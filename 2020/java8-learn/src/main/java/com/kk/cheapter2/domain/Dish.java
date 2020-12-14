package com.kk.cheapter2.domain;


import lombok.Data;

@Data
public class Dish {
    private String name;
    private boolean vegetarian;
    private int calories;
    private Type type;

    public Dish() {
    }

    public Dish(String name, boolean vegetarian, int calories, Type type) {
        this.name = name;
        this.vegetarian = vegetarian;
        this.calories = calories;
        this.type = type;
    }




    public enum Type {
        MEAT, FISH, OTHERS;
    }
}