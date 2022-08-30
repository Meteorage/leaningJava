package com.meteorage.lesson02;

import java.util.Arrays;

public class Task6 {
    public static void main(String[] args) {
        int[] arrInt = new int[]{2, 2, 2, 1, 2, 2, 10, 1};
        System.out.print(Arrays.toString(arrInt));
        System.out.println(" - " + checkBalance(arrInt));

        int[] arrInt2 = new int[]{1, 1, 1, 2, 1};
        System.out.print(Arrays.toString(arrInt2));
        System.out.println(" - " + checkBalance(arrInt2));

        int[] arrInt3 = new int[]{4, 1, 1, 2, 1};
        System.out.print(Arrays.toString(arrInt3));
        System.out.println(" - " + checkBalance(arrInt3));

        int[] arrInt4 = new int[]{4, 1, 1, 2, 12};
        System.out.print(Arrays.toString(arrInt4));
        System.out.println(" - " + checkBalance(arrInt4));
    }

    private static boolean checkBalance(int[] arrInt) {

        int sumPrefix, sumPostfix;

        sumPrefix = 0;
        sumPostfix = 0;
        for (int i = 0; i < arrInt.length; i++) {
            sumPostfix += arrInt[i];
        }
        sumPrefix = arrInt[0];
        sumPostfix -= arrInt[0];

        for (int i = 1; i < arrInt.length; i++) {
            if (sumPrefix == sumPostfix){
                return true;
            }
            sumPrefix += arrInt[i];
            sumPostfix -= arrInt[i];
        }
        return false;
    }


}
