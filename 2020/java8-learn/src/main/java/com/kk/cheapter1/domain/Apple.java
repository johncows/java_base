package com.kk.cheapter1.domain;

import lombok.Data;

@Data
public class Apple {
    private String color;
    private Integer weights;

    public Apple() {
    }

    public Apple(String color, Integer weights) {
        this.color = color;
        this.weights = weights;
    }
}
