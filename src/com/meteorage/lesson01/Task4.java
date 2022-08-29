package com.meteorage.lesson01;

public class Task4 {
    public static void main(String[] args) {
        int a = 10;
        int b = 6;
        System.out.println("Сумма лежит в интервале: " + checkIntervalSum(a,b));
        a = 15;
        System.out.println("Сумма лежит в интервале: " + checkIntervalSum(a,b));
    }
    private static boolean checkIntervalSum(int a, int b) {
        return (a+b)>10 && (a+b)<=20;
    }
}
