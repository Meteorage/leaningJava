package com.meteorage.lesson02;

import java.util.Arrays;

public class Task3 {
    public static void main(String[] args) {
        int[] arrInt = new int[]{ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };

        for (int i = 0; i < arrInt.length; i++) {
            if (arrInt[i] < 6){
                arrInt[i] *= 2;
            }
        }

        System.out.println("Результирующий массив");
        System.out.println(Arrays.toString(arrInt));
    }
}
