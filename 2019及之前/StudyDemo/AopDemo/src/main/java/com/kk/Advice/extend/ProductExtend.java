package com.kk.Advice.extend;

public class ProductExtend implements SecondHandSell {
    @Override
    public void productSell() {
        System.out.println("这件商品现在二手出售!!!!");
    }
}
