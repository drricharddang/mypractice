package com.company;

import java.util.*;

public class Main {

    static int getRandom(int min, int max) {
        return (int) (min + Math.random() * (max - min));
    }

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        int A = scanner.nextInt(); // uppercase
        int B = scanner.nextInt(); // lowercase
        int C = scanner.nextInt(); // digit
        int N = scanner.nextInt();

        char[] p = new char[N];
        Arrays.fill(p, '*');
        char c;
        char lastValue = '-';

        for (int i = 0; i < N; i++) {
            while (p[i] == '*') {
                c = (char) getRandom(48, 122);

                if (Character.isUpperCase(c) && A > 0 && c != lastValue) {
                    p[i] = c;
                    lastValue = c;
                    A--;
                } else if (Character.isLowerCase(c) && B > 0 && c != lastValue) {
                    p[i] = c;
                    lastValue = c;
                    B--;
                } else if (Character.isDigit(c) && C > 0 && c != lastValue) {
                    p[i] = c;
                    lastValue = c;
                    C--;
                }

                if (A == 0 && B == 0 && C == 0 && (Character.isUpperCase(c) || Character.isLowerCase(c) || Character.isDigit(c)) && c != lastValue) {
                    p[i] = c;
                    lastValue = c;
                }
            }
        }

        System.out.println(String.valueOf(p));
    }
}
