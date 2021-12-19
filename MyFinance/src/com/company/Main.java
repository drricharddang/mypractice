package com.company;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        System.out.println("IRR = " + calculator.internalRateOfReturn(5));
    }
}
