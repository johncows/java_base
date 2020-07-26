package com.kk.Advice;

public class PayAdvice2 {


    public void beforePay() {
        System.out.println("查看你的金额 十元");
    }

    public void inPay() {
        System.out.println("需要支付五元 正在支付中");
    }

    public void successPay() {
        System.out.println("支付完成 还剩五元");
    }

    public void errorPay() {
        System.out.println("请充值");
    }

    public void afterPay() {
        System.out.println("交易结束");
    }
}
