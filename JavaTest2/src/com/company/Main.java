package com.company;

class TestMethods {
    static int getLuhnNumber(String accID) {
        String loadNumber = "400000" + accID;
        int digit;
        int sum = 0;

        for (int i = 0; i < loadNumber.length(); i++) {
            digit = Character.getNumericValue(loadNumber.charAt(i));
            if (i % 2 == 0) {
                sum += (digit * 2 > 9 ? digit * 2 - 9 : digit * 2);
            } else {
                sum += digit;
            }
            System.out.println(i + " " + sum);
        }

        System.out.println(sum);

        return sum % 10 == 0 ? 0 : 10 - sum%10;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(TestMethods.getLuhnNumber("937101561"));
    }
}
