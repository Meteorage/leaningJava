package com.meteorage.lesson05;

public class Task01 {

    public static void main(String[] args) {
        Person[] persArray = new Person[5];

        persArray[0] = new Person("Ivanov Ivan", "Engineer", "ivanov@mail.com", "+7-932-00-00-000", 10000, 30);
        persArray[1] = new Person("Petrov Petr", "Engineer", "petrov@mail.com", "+79220000000", 11000, 45);
        persArray[2] = new Person("Guseva Ksu", "Analytic", "guseva@mail.com", "+79120000000", 12000, 26);
        persArray[3] = new Person("Sergova Anna", "Analytic", "sergova@mail.com", "+79130000000", 9000, 30);
        persArray[4] = new Person("Vologin Seva", "Engineer 1C", "vologin@mail.com", "+79050000000", 15000, 41);

        System.out.print("Список сотрудников старше 40: ");
        if (Person.countPersOver40 > 0) {
            System.out.println();
            for (Person person : persArray) {
                if (person.getAge() > 40) {
                    System.out.println(person);
                }
            }
        }
        else {
            System.out.println("Список пуст");
        }
    }
}
