package com.meteorage.lesson02;

import java.util.Arrays;

public class Task7 {
    public static void main(String[] args) {
        int[] arrInt = new int[]{-5, 5, 3, 2, 11, 3, 5, 2, 4, 8, 9, 1};
        System.out.print(Arrays.toString(arrInt));

        int shift = 1;

        shiftArr(arrInt, shift);
        System.out.println();
        System.out.print(Arrays.toString(arrInt));

        int[] arrInt2 = new int[]{-5, 5, 3, 2, 11, 3, 5, 2, 4, 8, 9, 1};
        shift = -1;
        shiftArr(arrInt2, shift);
        System.out.println();
        System.out.print(Arrays.toString(arrInt2));
    }

    private static void shiftArr(int[] arrInt, int shift) {

        int localShift;
        if (shift < 0) {
            localShift = (arrInt.length + (shift % arrInt.length)) % arrInt.length;
        } else {
            localShift = shift % arrInt.length;
        }

        for (int i = 0; i < localShift; i++) {
            for (int j = 0, buf = 0; j < arrInt.length; j++) {
                if (j == 0) {
                    buf = arrInt[j];
                } else {
                    if (j == arrInt.length - 1) {
                        arrInt[j - 1] = arrInt[j];
                        arrInt[j] = buf;
                    } else {
                        arrInt[j - 1] = arrInt[j];
                    }
                }
            }
        }
    }

}
