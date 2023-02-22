package com.meteorage.lesson04;

import java.util.Random;
import java.util.Scanner;

public class Task1 {

    static Point point = new Point();
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

        boolean isEndGame;

        prepareField();
        showMap();

        do {


            turnHuman();
            showMap();
            isEndGame = checkWin(DOT_HUMAN);
            if (isEndGame) {
                System.out.println("Вы победили!!!");
                break;
            }

            turnAI();
            showMap();
            isEndGame = checkWin(DOT_AI);
            if (isEndGame) {
                System.out.println("Компьютер выиграл!");
            }
        } while (!isEndGame);

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

            if (checkBlockCell(row, col, DOT_HUMAN)){
                if (point.X != -1 || point.Y != -1) {
                    row = point.X;
                    col = point.Y;
                }
            }else{
                if (checkBlockCell(row, col, DOT_AI)){
                    if (point.X != -1 || point.Y != -1) {
                        row = point.X;
                        col = point.Y;
                    }
                }
            }

        } while (!cellIsFree(row, col, false));
        map[row][col] = DOT_AI;

        point.X = -1;
        point.Y = -1;
    }

    private static boolean checkWin(char dotType) {
        boolean res = false;
        for (int i = 0; i < (SIZE_FIELD - COUNT_TO_WIN + 1); i++) {
            for (int j = 0; j < SIZE_FIELD - COUNT_TO_WIN + 1; j++) {
                res = checkSquareToWin(i, j, dotType);
                if (res) {
                    return res;
                }
            }
        }
        return res;

    }

    private static boolean checkSquareToWin(int x, int y, char dotType) {
        int countDotX;
        int countDotY;
        int countDotXY = 0;
        int countDotYX = 0;
        for (int i = x; i < x + COUNT_TO_WIN; i++) {
            countDotX = 0;
            countDotY = 0;
            for (int j = y; j < y + COUNT_TO_WIN; j++) {
                if (map[i][j] == dotType) {
                    countDotX++;
                }
                if (map[j][i] == dotType) {
                    countDotY++;
                }
            }
            if (map[i][i] == dotType) {
                countDotXY++;
            }
            if (map[i][x + COUNT_TO_WIN - i] == dotType) {
                countDotYX++;
            }
            if (countDotX == COUNT_TO_WIN || countDotY == COUNT_TO_WIN || countDotXY == COUNT_TO_WIN || countDotYX == COUNT_TO_WIN) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkBlockCell(int row, int col, char dot) {
        boolean res = false;
        for (int i = 0; i < (SIZE_FIELD - COUNT_TO_WIN + 1); i++) {
            for (int j = 0; j < SIZE_FIELD - COUNT_TO_WIN + 1; j++) {
                res = checkSquareToPrepareWin(i, j, dot);
                if (res) {
                    return res;
                }
            }
        }
        return res;
    }

    private static boolean checkSquareToPrepareWin(int x, int y, char dotType) {
        int bufferX = -1, bufferY = -1;
        int countDot;

        //TODO отрефакторить
        for (int i = x; i < x + COUNT_TO_WIN; i++) {
            countDot = 0;
            for (int j = y; j < y + COUNT_TO_WIN; j++) {
                if (map[i][j] == dotType) {
                    countDot++;
                } else {
                    if (map[i][j] == DOT_EMPTY) {
                        bufferX = i;
                        bufferY = j;
                    }else {
                        countDot--;
                    }
                }
            }
            if (countDot == COUNT_TO_WIN - 1) {
                point.X = bufferX;
                point.Y = bufferY;
                return true;
            }
        }
        for (int j = x; j < x + COUNT_TO_WIN; j++) {
            countDot = 0;
            for (int i = y; i < y + COUNT_TO_WIN; i++) {
                if (map[i][j] == dotType) {
                    countDot++;
                } else {
                    if (map[i][j] == DOT_EMPTY) {
                        bufferX = i;
                        bufferY = j;
                    }else {
                        countDot--;
                    }
                }
            }
            if (countDot == COUNT_TO_WIN - 1) {
                point.X = bufferX;
                point.Y = bufferY;
                return true;
            }
        }
        point.X = -1;
        point.Y = -1;
        return false;
    }
}
