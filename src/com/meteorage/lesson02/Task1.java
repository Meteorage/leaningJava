package com.meteorage.lesson02;

import java.util.Arrays;

public class Task1 {
    public static void main(String[] args) {
        int[] arrInt = new int[]{1,0,1,1,0,0,1,1};

        System.out.println("Исходный массив");
        System.out.println(Arrays.toString(arrInt));

        for (int i = 0; i < arrInt.length; i++) {
            arrInt[i] = (arrInt[i] == 1) ? 0 : 1;
        }
        System.out.println("Исходный массив");
        System.out.println(Arrays.toString(arrInt));
    }
}
