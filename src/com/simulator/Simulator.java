package com.simulator;

import java.util.Arrays;

import com.portfolio.DistributionResult;
import com.portfolio.Portfolio;

public class Simulator {
    public static double INVESTMENT = 100000;
    public static float ANNUAL_INFLATION = 3.5f;

    public static double MEAN_AGGRESSIVE = 9.4324;
    public static double SD_AGGRESSIVE = 15.675;

    public static double MEAN_CONSERVATIVE = 6.189;
    public static double SD_CONSERVATIVE = 6.3438;

    public static int NUM_OF_YEAR = 20;

    public static int NUM_SIMULATIONS = 10000;

    public DistributionResult simulateDistribution(double mean,
            double standardDeviation, double investedAmount, int numYears,
            float annualInflation) {
        DistributionResult distributionResult = new DistributionResult();
        double[] portfolioVals = getSortedSimulationValues(mean,
                standardDeviation, investedAmount, numYears, annualInflation);
        distributionResult.setMedian(portfolioVals[NUM_SIMULATIONS / 2]);
        distributionResult
                .setPercentile10(portfolioVals[NUM_SIMULATIONS * 10 / 100]);
        distributionResult
                .setPercentile90(portfolioVals[NUM_SIMULATIONS * 9 / 10]);

        return distributionResult;
    }

    public double[] getSortedSimulationValues(double mean,
            double standardDeviation, double investedAmount, int numYears,
            float annualInflation) {
        double portfolioVals[] = new double[NUM_SIMULATIONS];
        Portfolio portfolio = new Portfolio(mean, standardDeviation);
        for (int i = 0; i < NUM_SIMULATIONS; i++) {
            double agBalance = portfolio.calculateDistribution(investedAmount,
                    numYears, annualInflation);
            portfolioVals[i] = agBalance;
        }
        Arrays.sort(portfolioVals);
        return portfolioVals;
    }

    public DistributionResult simulateDistributionForAggressive() {
        return simulateDistribution(MEAN_AGGRESSIVE, SD_AGGRESSIVE, INVESTMENT,
                NUM_OF_YEAR, ANNUAL_INFLATION);
    }

    public DistributionResult simulateDistributionForConservative() {
        return simulateDistribution(MEAN_CONSERVATIVE, SD_CONSERVATIVE,
                INVESTMENT, NUM_OF_YEAR, ANNUAL_INFLATION);
    }

    public void printDistributionSimulationForAggressive() {
        System.out.println(simulateDistributionForAggressive().getString());
    }

    public void printDistributionSimulationForConservative() {
        System.out.println(simulateDistributionForConservative().getString());
    }
}
