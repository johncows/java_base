package com.kk.demo02.StrategyMode;

// 策略模式 将进行计算的组件单独抽取出来 分割业务
public class TestDemo {

    public static void main(String[] args) {

        SalaryCount salaryCount = new SalaryCount(10000,200);

        salaryCount.setCalcMode((a,b)-> a*0.9+b*0.5);


        double realSalary = salaryCount.getRealSalary();

        System.out.println("realSalary = " + realSalary);


    }
}
