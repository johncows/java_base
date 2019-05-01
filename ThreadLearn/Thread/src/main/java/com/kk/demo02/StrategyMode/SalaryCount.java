package com.kk.demo02.StrategyMode;

import lombok.Data;

@Data
public class SalaryCount {

    private double baseSalary;
    private double bonus;

    public SalaryCount(double baseSalary, double bonus) {
        this.baseSalary = baseSalary;
        this.bonus = bonus;
    }

    private CalcMode calcMode;

    protected double getRealSalary(){
        return calcMode.calc(baseSalary,bonus);
    }

}
