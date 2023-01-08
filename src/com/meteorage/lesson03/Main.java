package com.meteorage.lesson03;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] a = {0,0,0,0,0,0};

        System.out.println("a = " + Arrays.toString(a));
        testArrayChange(a);

        System.out.println("a = " + Arrays.toString(a));

        testString();


        testOverload(3,4);
        testOverload(3.34,4.56456);
        testOverload();
        testOverload(new int[]{1,2,3,4,5,6,7,8,9,10});
        testOverload(1,2,3,4,5,6,7,8,9,10);
    }


    private static void testString() {
        String str1 = "Java";
        String str2 = "Java";
        String str3 = new String("Java");

        System.out.println("str1 == str2: " + (str1 == str2));
        System.out.println("str1 == str3: " + (str1 == str3));
        System.out.println("str1 == str3: " + (str1.equals(str3)));

    }

    private static void testArrayChange(int[] a) {
        for (int i = 0; i < a.length; i++) {
            a[i] = i;
        }
    }

    private static void testOverload(int a, int b) {
        int multiple =  a * b;
        System.out.printf("Произведение %d * %d = %d(int)%n", a, b, multiple);
    }
    private static void testOverload(double a, double b) {
        double multiple =  a * b;
        System.out.printf("Произведение %.2f * %.2f = %.2f(double)%n", a, b, multiple);
    }

    private static void testOverload() {
        testOverload(0,0);
    }

    private static void testOverload(int... arr) {
        int multiple =  1;
        for (int item : arr) {
            multiple *= item;
        }
        System.out.printf("Произведение: %d(int)%n", multiple);
    }
}
