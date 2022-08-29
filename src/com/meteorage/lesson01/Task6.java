package com.meteorage.lesson01;

public class Task6
{
    public static void main(String[] args) {
        System.out.println("Digit is negative: " + checkNegativeNumber(0));
        System.out.println("Digit is negative: " + checkNegativeNumber(-1));
    }

    private static boolean checkNegativeNumber(int a) {
        return a < 0;
    }

}
