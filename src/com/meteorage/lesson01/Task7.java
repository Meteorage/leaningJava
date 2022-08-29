package com.meteorage.lesson01;

public class Task7 {
    public static void main(String[] args) {
        String varString = "Вася!";
        printHello(varString);
    }
    private static void printHello(String varString) {
        System.out.printf("Привет, %s!", varString);
        System.out.println();
    }
}
