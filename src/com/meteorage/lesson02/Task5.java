package com.meteorage.lesson02;

import java.util.Arrays;

public class Task5 {
    public static void main(String[] args) {
        int[] arrInt = new int[]{ -5, 5, 3, 2, 11, 3, 5, 2, 4, 8, 9, 1 };

//
//
//        int min = arrInt[0];
//        int max = arrInt[0];
//
//        for (int i = 0; i < arrInt.length; i++) {
//            if (arrInt[i] < min){
//                min = arrInt[i];
//            }
//            if (arrInt[i] > max){
//                max = arrInt[i];
//            }
//        }
//        System.out.printf("Минимальное значение в массиве: %d%n", min);
//        System.out.printf("Максимальное значение в массиве: %d", max);

        Arrays.sort(arrInt);

        System.out.printf("Минимальное значение в массиве: %d%n", arrInt[0]);
        System.out.printf("Максимальное значение в массиве: %d", arrInt[arrInt.length-1]);
    }
}
