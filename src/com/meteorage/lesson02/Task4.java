package com.meteorage.lesson02;

import java.util.Arrays;

public class Task4 {

    public static void main(String[] args) {

        final int SIZE = 7;

        int[][] arrInt = new int[SIZE][SIZE];

        for (int i = 0; i < SIZE; i++) {
            arrInt[i][i] = 1;
            arrInt[SIZE-i-1][i] = 1;
        }

        for (int[] ints : arrInt) {
            for (int anInt : ints) {
                System.out.printf("%2d", anInt);
            }
            System.out.println();
        }
    }
}
