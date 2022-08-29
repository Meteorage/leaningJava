package com.meteorage.lesson01;

public class Task6
{
    public static void main(String[] args) {
        int a = 0;
        System.out.println("Number is negative: " + checkNegativeNumber(a));
        a = -1;
        System.out.println("Number is negative: " + checkNegativeNumber(a));
    }

    private static boolean checkNegativeNumber(int a) {
        return a < 0;
    }

}
