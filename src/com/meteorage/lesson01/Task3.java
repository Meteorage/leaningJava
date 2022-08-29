package com.meteorage.lesson01;

public class Task3 {

    public static void main(String[] args) {
        int a,b,c,d;
        a = 10;
        b = 1;
        c = 3;
        d = 5;
        System.out.println("Результат вычисления равен: " + calculateExpression(a,b,c,d));
        d = 0;
        System.out.println("Результат вычисления равен: " + calculateExpression(a,b,c,d));
    }
    private static float calculateExpression(int a, int b, int c, int d) {
        if (d == 0) {
            System.out.println("Division by zero!");
            return 0;
        } else {
            return a*(b+(float)c/d);

        }
    }
}
