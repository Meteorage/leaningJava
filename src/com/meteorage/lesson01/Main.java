package com.meteorage.lesson01;

public class Main {

    public static void main(String[] args) {

        //Задание 2
        byte varByte = 125;
        short varShort = 5;
        int vatInt = 2_000_000;
        long varLong = 8_000_000L;
        float varFloat = 5/8;
        double varDouble = 5/18;
        boolean varBoolean = true;
        char varChar = 1001;
        String varString = "Hello world";

        //Задание 3
        int a,b,c,d;
        a = 5;
        b = 6;
        c = 3;
        d = 1;
        System.out.println("Результат вычисления равен: " + calculateExpression(a,b,c,d));
        d = 0;
        System.out.println("Результат вычисления равен: " + calculateExpression(a,b,c,d));

        //Задание 4
        System.out.println("Сумма лежит в интервале: " + checkIntervalSum(a,b));
        a = 15;
        System.out.println("Сумма лежит в интервале: " + checkIntervalSum(a,b));

        //Задание 5
        a = 0;
        printPositiveNegativeNumber(a);
        a = -1;
        printPositiveNegativeNumber(a);

        //Задание 6
        a = 0;
        System.out.println("Number is negative: " + checkNegativeNumber(a));
        a = -1;
        System.out.println("Number is negative: " + checkNegativeNumber(a));

        //Задание 7
        varString = "Вася!";
        printHello(varString);

        //Задание 8*
        vatInt = 2022;
        System.out.println("year "+vatInt+ " is leap: " + checkLeapYear(vatInt));
        vatInt = 2020;
        System.out.println("year "+vatInt+ " is leap: " + checkLeapYear(vatInt));
        vatInt = 2000;
        System.out.println("year "+vatInt+ " is leap: " + checkLeapYear(vatInt));

    }

    private static float calculateExpression(int a, int b, int c, int d) {
        if (d == 0){
            System.out.println("Division by zero!");
            return 0;
        }else {
            return a*(b+(c/d));
        }
    }

    private static boolean checkIntervalSum(int a, int b) {
        return (a+b)>10 && (a+b)<=20;
    }

    private static void printPositiveNegativeNumber(int a) {
        if (a>=0){
            System.out.println("a is positive number");
        }
        else {
            System.out.println("a is negative number");
        }
    }

    private static boolean checkNegativeNumber(int a) {
        return a < 0;
    }

    private static void printHello(String varString) {
        System.out.printf("Привет, %s!", varString);
        System.out.println();
    }

    private static boolean checkLeapYear(int vatInt) {
        return ((vatInt % 4 == 0) && (vatInt % 100 != 0)) || ((vatInt % 4 == 0) && (vatInt % 400 == 0));
    }
}
