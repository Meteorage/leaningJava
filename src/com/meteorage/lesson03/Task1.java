package com.meteorage.lesson03;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/*      Создать массив из слов String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        При запуске программы компьютер загадывает слово, запрашивает ответ у пользователя,
        сравнивает его с загаданным словом и сообщает правильно ли ответил пользователь. Если слово не угадано, компьютер показывает буквы которые стоят на своих местах.
        apple – загаданное
        apricot - ответ игрока
        ap############# (15 символов, чтобы пользователь не мог узнать длину слова)
        Для сравнения двух слов посимвольно, можно пользоваться:
        String str = "apple";
        str.charAt(0); - метод, вернет char, который стоит в слове str на первой позиции
        Играем до тех пор, пока игрок не отгадает слово
        Используем только маленькие буквы
 */
public class Task1 {
    static String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
    static char[][] wordField = new char[2][15];
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        Boolean wordGuessed = false;
        Boolean sucсess = false;

        while (true){
            if (wordGuessed == false){
                System.out.print("Компьютер загадал одно из слов: ");
                System.out.println(Arrays.toString(words));
                initWord();
                wordGuessed = true;
            }

            System.out.print("Комп загадал слово: ");
            System.out.println(Arrays.toString(wordField[1]));

            System.out.println(Arrays.toString(wordField[0]));
            System.out.print("Введите загаданное слово: ");
            String tempWord = scanner.next();
            
            for (int i = 0; i < tempWord.length(); i++) {
                char tempChar = tempWord.charAt(i);
                if (tempChar == wordField[1][i]){
                    wordField[0][i] = tempChar;
                }
            }

            sucсess = true;
            for (int i = 0; i < wordField.length; i++) {
                if (wordField[0][i] != wordField[1][i]){
                    sucсess = false;
                }
            }
            

            if (sucсess == true){
                System.out.println("Вы угадали слово! Хотите продолжить? y/n?");
                String result = scanner.next();
                switch (result){
                    case "y":
                    case "+":
                    case "да":
                    case "yes":
                    case "д": {
                        wordGuessed = false;
                        sucсess = false;
                        }
                    default: {
                        System.exit(0);
                    }
                }
            }
        }
    }

    private static void initWord(){

        Random random = new Random();
        String selectWords = words[random.nextInt(words.length)];

        for (int i = 0; i < wordField[0].length; i++) {
            wordField[0][i] = '#';
            if (i<selectWords.length()){
                wordField[1][i] = selectWords.charAt(i);
            }else{
                wordField[1][i] = '#';
            }
        }
    }
}
