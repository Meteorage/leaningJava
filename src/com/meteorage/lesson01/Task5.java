package com.meteorage.lesson01;

public class Task5 {
    public static void main(String[] args) {
        int a = 0;
        printPositiveNegativeNumber(a);
        a = -1;
        printPositiveNegativeNumber(a);
    }
    private static void printPositiveNegativeNumber(int a) {
        if (a>=0){
            System.out.println("a is positive number");
        }
        else {
            System.out.println("a is negative number");
        }
    }
}
