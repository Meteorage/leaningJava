package com.meteorage.lesson02;

public class Main {
    public static void main(String[] args) {
        //System.out.println("Hello");

        //System.out.println(convertSeasonBySwitch(3));

        int[][] deepArr = new int[7][7];

        int n = 0;
        for (int i = 0; i < deepArr.length; i++) {
            for (int j = 0; j < deepArr[i].length; j++) {
                deepArr[i][j] = ++n;
            }
        }

        for (int[] ints : deepArr) {
            for (int anInt : ints) {
                System.out.printf("%3d ",anInt);
            }
            System.out.println();
        }

//        for (int i = 0; i < deepArr.length; i++) {
//            for (int j = 0; j < deepArr[i].length; j++) {
//
//                System.out.printf("%5d ",deepArr[i][j]);
//            }
//            System.out.println();
//        }

    }

    private static String convertSeasonBySwitch(int i) {
        String season;

        return switch (i) {
            case 1 -> "Winter";
            case 2 -> "Spring";
            case 3 -> "Summer";
            case 4 -> "Fall";
            default -> "Unknown season";
        };

//        switch (i){
//            case 1,2,3 : return "1";
//            case 4,5,6 : return "2";
//            case 7,8,9 : return "3";
//            case 10,11,12 : return "4";
//        }
    }
}
