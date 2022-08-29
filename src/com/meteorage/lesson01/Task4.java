package com.meteorage.lesson01;

public class Task4 {
    public static void main(String[] args) {
        System.out.println("Сумма лежит в интервале: " + checkIntervalSum(10,6));
        System.out.println("Сумма лежит в интервале: " + checkIntervalSum(10,15));
    }
    private static boolean checkIntervalSum(int a, int b) {
        return (a+b)>10 && (a+b)<=20;
    }
}
