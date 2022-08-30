package com.meteorage.lesson02;

import java.util.Arrays;

public class Task2 {
    public static void main(String[] args) {
        int [] arrInt = new int[8];

        for (int i = 0, k = 0; i < arrInt.length; i++) {
            arrInt[i] = k;
            k += 3;
        }

        System.out.println("Массив");
        System.out.println(Arrays.toString(arrInt));
    }


}
