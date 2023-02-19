package com.meteorage.lesson04;

import java.util.Random;
import java.util.Scanner;

/*
1. Полностью разобраться с кодом, попробовать переписать с нуля, стараясь не подглядывать в методичку;
2. Переделать проверку победы, чтобы она не была реализована просто набором условий, например, с использованием циклов.
3. * Попробовать переписать логику проверки победы, чтобы она работала для поля 5х5 и количества фишек 4. Очень желательно не делать это просто набором условий для каждой из возможных ситуаций;
4. *** Доработать искусственный интеллект, чтобы он мог блокировать ходы игрока.
*/

public class Task1 {

    static final byte SIZE_FIELD = 4;
    static final byte COUNT_TO_WIN = 3;
    static char[][] map = new char[SIZE_FIELD][SIZE_FIELD];
    static Scanner in = new Scanner(System.in);
    static Random random = new Random();

    static final char DOT_EMPTY = '·';
    static final char DOT_HUMAN = 'x';
    static final char DOT_AI = 'o';
    static final String DOT = " ";

    public static void main(String[] args) {

        startGame();
    }

    private static void startGame() {

        boolean isEndGame = false;

        prepareField();
        showMap();

        do {


        turnHuman();
        showMap();
        isEndGame = checkWin(DOT_HUMAN);
        if (isEndGame){
            System.out.println("Вы победили!!!");
            break;
        }

        turnAI();
        showMap();
        isEndGame = checkWin(DOT_AI);
        if (isEndGame){
            System.out.println("Компьютер выиграл!");
        }
        }while (!isEndGame);

    }

    private static void prepareField() {
        for (int i = 0; i < SIZE_FIELD; i++) {
            for (int j = 0; j < SIZE_FIELD; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    private static void showMap() {
        System.out.print(DOT);
        for (int i = 0; i < SIZE_FIELD; i++) {
            System.out.print(DOT + (i + 1));
        }

        System.out.println();
        for (int i = 0; i < SIZE_FIELD; i++) {
            System.out.print(i + 1);
            for (int j = 0; j < SIZE_FIELD; j++) {
                System.out.print(DOT + map[i][j]);
            }
            System.out.println();
        }
    }

    private static void turnHuman() {
        int row, col;

        do {
            row = 0;
            col = 0;
            System.out.print("Введите номер строки: ");
            if (in.hasNextInt()) {
                row = in.nextInt() - 1;
            } else {
                in.next();
                System.out.print("Введите число: ");
                continue;
            }

            System.out.print("Введите номер колонки: ");
            if (in.hasNextInt()) {
                col = in.nextInt() - 1;
            } else {
                in.next();
                System.out.print("Введите число: ");
            }
        } while (!checkCorrectNumber(row, col) && !cellIsFree(row, col, true));

        map[row][col] = DOT_HUMAN;
    }

    private static boolean cellIsFree(int row, int col, boolean isHuman) {
        if (map[row][col] == DOT_EMPTY) {
            return true;
        } else {
            if (isHuman) {
                System.out.println("Ячейка занята!");
            }
            return false;
        }
    }

    private static boolean checkCorrectNumber(int row, int col) {
        return row < 0 || row > SIZE_FIELD || col < 0 || col > SIZE_FIELD;
    }

    private static void turnAI() {
        int row, col;
        do {
            row = random.nextInt(SIZE_FIELD);
            col = random.nextInt(SIZE_FIELD);

            checkBlockCell(row,col);

        } while (!cellIsFree(row, col, false));
        map[row][col] = DOT_AI;
    }

    private static boolean checkWin(char dotType) {
        boolean res = false;
        for (int i = 0; i < (SIZE_FIELD-COUNT_TO_WIN+1); i++) {
            for (int j = 0; j < SIZE_FIELD-COUNT_TO_WIN+1; j++) {
                res = checkSquareToWin(i,j,dotType);
                if (res){
                    return res;
                }
            }
        }
        return res;

    }

    private static boolean checkSquareToWin(int x, int y, char dotType) {
        int countDotX = 0;
        int countDotY = 0;
        int countDotXY = 0;
        int countDotYX = 0;
        for (int i = x; i < x+COUNT_TO_WIN; i++) {
            countDotX = 0;
            countDotY = 0;
            for (int j = y; j < y+COUNT_TO_WIN; j++) {
                if (map[i][j] == dotType){
                    countDotX++;
                }
                if (map[j][i] == dotType){
                    countDotY++;
                }
            }
            if (map[i][i] == dotType){
                countDotXY++;
            }
            if (map[i][x+COUNT_TO_WIN - i] == dotType){
                countDotYX++;
            }
            if (countDotX == COUNT_TO_WIN || countDotY == COUNT_TO_WIN || countDotXY == COUNT_TO_WIN || countDotYX == COUNT_TO_WIN) {
                return true;
            }
        }
        return false;
    }

    private static void checkBlockCell(int row, int col) {
//        boolean res = false;
//        for (int i = 0; i < (SIZE_FIELD-COUNT_TO_WIN+1); i++) {
//            for (int j = 0; j < SIZE_FIELD-COUNT_TO_WIN+1; j++) {
//                res = checkSquareToWin(i,j,DOT_HUMAN);
//                if (res){
//                    return res;
//                }
//            }
//        }
//        return res;
    }
}
