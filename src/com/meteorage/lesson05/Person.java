package com.meteorage.lesson05;

public class Person {
    private String fio;
    private String position;
    private String email;
    private String telephone;
    private int salary;
    private int age;

    static public int countPersOver40;

    public Person(String fio, String position, String email, String telephone, int salary, int age) {
        this.fio = fio;
        this.position = position;
        this.email = email;
        this.telephone = telephone;
        this.salary = salary;
        this.age = age;

        if (age > 40){
            countPersOver40++;
        }
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return fio + "(position: " + position + "; e-mail: " + email + "; telephone: " + telephone + "; age: " + age +  "; salary: " + salary + ")";
    }

}
