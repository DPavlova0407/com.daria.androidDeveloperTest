package com.daria.androidDeveloperTest.tasks.Task1;

/**
 * Created by Daria on 05.02.2018.
 */
public class User {
    private String name;
    private String surname;
    private int age;

    public void myAgeException() throws AgeException {
        System.out.println("Неверный возраст");
        throw new AgeException();
    }

    public User(String name, String surname, int age){
        if (age > 0 && age< 200) {
            this.name = name;
            this.surname = surname;
            this.age = age;
        }else {
            AgeException e = new AgeException();
            e.printStackTrace();
        }
    }
    public String getName(){
        return this.name;
    }
    public String getSurname(){
        return this.surname;
    }
    public int getAge(){
        return this.age;
    }
    @Override
    public String toString(){
        return this.name + " " + this.surname + " " + this.age;
    }

    class AgeException extends Exception { // исключение - неверно введенный возраст при создании нового пользователя
        AgeException() {
        }
        AgeException(String msg) {
            super(msg);
        }
    }
}
