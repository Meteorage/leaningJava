package com.meteorage.lesson01;

public class Task8 {
    public static void main(String[] args) {
        int vatInt = 2022;
        System.out.println("year "+vatInt+ " is leap: " + checkLeapYear(vatInt));
        vatInt = 2020;
        System.out.println("year "+vatInt+ " is leap: " + checkLeapYear(vatInt));
        vatInt = 2000;
        System.out.println("year "+vatInt+ " is leap: " + checkLeapYear(vatInt));
    }
    private static boolean checkLeapYear(int vatInt) {
        return ((vatInt % 4 == 0) && (vatInt % 100 != 0)) || ((vatInt % 4 == 0) && (vatInt % 400 == 0));
    }
}
