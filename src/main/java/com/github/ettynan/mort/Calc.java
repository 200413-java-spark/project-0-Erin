package com.github.ettynan.mort;

import java.lang.Math;
import com.github.ettynan.mort.Info;


public class Calc extends Info{
    private float monthlyInterest;
    private double hundred = 100;
    private int numOfPayments;
    private int monthsPerYear = 12;
    private float factor;
    private float power;
    private double avgCost;
    private double principle;

    public Calc(ReadIn readIn) {
        this.monthlyInterest = (float)(super.interest/hundred)/this.monthsPerYear;
        this.numOfPayments = super.years * this.monthsPerYear;
        this.power = this.getPower();
        this.avgCost = readIn.getHouseCost().get(super.zip);
        this.principle = this.avgCost - super.downPay;
        this.factor = (monthlyInterest)/((float) power);
    }
    
    public float getPower(){
        return (float) (1 - Math.pow((1 + this.monthlyInterest),(-1 * this.numOfPayments)));
    }
    
    public float getFactor(){
        return (this.monthlyInterest)/(this.power);
    }

    public double getMonthlyPay(){
        return (this.factor * this.principle);
    }

    @Override
    public String toString(){
        return "\nYour estimated monthly payment is $" + String.format("%.2f", getMonthlyPay());
    }
}