package com.kk.Pojo;


import com.kk.Advice.extend.SecondHandSell;

import java.util.Random;


public class Product {

    private String pName;
    private Integer price;

    public Product() {

    }

    public Product(String pName, Integer price) {
        this.pName = pName;
        this.price = price;
    }

    public void buyProduct() {
        System.out.println("商品名：" + pName + " 商品价格：" + price);
        if (new Random().nextBoolean()) {
            System.out.println("余额不足 嘟嘟嘟...");
            int i = 1 / 0;
        }
    }


    public void checkProductStatus(String message) {
        System.out.println("执行方法体内部-->" + message);
    }


    @Override
    public String toString() {
        return "Product{" +
                "pName='" + pName + '\'' +
                ", price=" + price +
                '}';
    }


    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
