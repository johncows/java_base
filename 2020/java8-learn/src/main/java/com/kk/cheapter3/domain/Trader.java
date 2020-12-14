package com.kk.cheapter3.domain;

import lombok.Data;

/**
 * @author wangjunkang
 * @version 1.0
 * @description: TODO
 * @date 11/26/20 6:25 PM
 */
@Data
public class Trader {
    private final String name;
    private final String city;

    public Trader(String n, String c) {
        this.name = n;
        this.city = c;
    }
}
