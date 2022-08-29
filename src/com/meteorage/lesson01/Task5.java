package com.meteorage.lesson01;

public class Task5 {
    public static void main(String[] args) {
        printPositiveNegativeNumber(1);
        printPositiveNegativeNumber(0);
        printPositiveNegativeNumber(-1);
    }
    private static void printPositiveNegativeNumber(int a) {
        String word = (a>=0) ? "positive" : "negative";
        System.out.printf("This number(%d) is %s digit%n", a, word);
    }
}
