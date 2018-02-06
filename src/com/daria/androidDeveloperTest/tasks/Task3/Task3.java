package com.daria.androidDeveloperTest.tasks.Task3;

import com.daria.androidDeveloperTest.Task;

import java.util.Scanner;

/**
 * Created by Daria on 05.02.2018.
 */
public class Task3 implements Task {
    Scanner scanner;
    @Override
    public void run(){
        scanner = new Scanner(System.in);
        System.out.println("Введите слово для проверки");
        String word = scanner.nextLine();
        while (!word.equals("выйти")) {
            if (isPalindrom(word))
                System.out.println("Строка является палиндромом");
            else
                System.out.println("Это не палиндром");
            System.out.println("Чтобы выйти из программы введите \'выйти\'");
            word = scanner.nextLine();
        }
    }
    public boolean isPalindrom(String a){
        if (a.length() < 2)
            return true;
        int n = a.length();
        for (int i= 0; i < n/2; i++){
            if (a.charAt(i) != a.charAt(n-i-1))
                return false;
        }
        return true;
    }
}
