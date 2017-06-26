package com.portfolio;

import java.util.Random;

public class Portfolio {

    private double mean;
    private double standardDev;

    public Portfolio(double mean, double standardDev) {
        this.mean = mean;
        this.standardDev = standardDev;
    }

    public double calculateRateOfReturn() {
        Random rd = new Random();
        return rd.nextGaussian() * this.standardDev + this.mean;
    }

    public double calculateInflation(double amount, double inflationRate) {
        return amount * (inflationRate / 100.0f);
    }

    public double calculateDistribution(double investedAmount, int numYears,
            float annualInflation) {
        double balance = investedAmount;
        
        for (int i = 0; i < numYears; i++) {
            double endBal = balance
                    + (balance * (calculateRateOfReturn() / 100.0f));
            if (i > 0) {
                endBal = endBal + calculateInflation(endBal, annualInflation);
            }
            balance = endBal;
        }
        return balance;
    }

}
