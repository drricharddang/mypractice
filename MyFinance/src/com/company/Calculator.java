package com.company;

import java.util.Scanner;

public class Calculator {
    Scanner scanner = new Scanner(System.in);

    double increasePctToReverseLoss (double lossPct) {
        return lossPct / (1 - lossPct) ;
    }

    double compoundInvestReturn(double initialInvestment, double interestRate, int numberOfPeriods) {
        double asset = initialInvestment;

        for (int i = 1; i <= numberOfPeriods; i++) {
            asset = asset * (1 + interestRate / 100);
        }
        return Math.round(asset);
    }

    double internalRateOfReturn(int numberOfPeriods) {
        double internalRateOfReturn = 0.0000;
        double[] cashFlow = new double[numberOfPeriods];
        double[] r = new double[numberOfPeriods];
        double accumulatedInterest = 1;
        double initialInvestment = 0;

        while (initialInvestment >=0) {
            System.out.print("Please input Initial Investment (Must be NEGATIVE): ");
            initialInvestment = scanner.nextDouble();
        }

        for (int i = 0; i < numberOfPeriods; i++) {
            System.out.print("Cash Flow for period # " + (i+1) + ": ");
            cashFlow[i] = scanner.nextDouble();
            r[i] = Math.pow (cashFlow[i] / -initialInvestment, 1/(i+1)) - 1;
            accumulatedInterest *= 1 + r[i];
        }

        internalRateOfReturn = Math.pow(accumulatedInterest, 1/numberOfPeriods) - 1;

        return internalRateOfReturn;
    }
}
