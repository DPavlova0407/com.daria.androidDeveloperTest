package com.daria.androidDeveloperTest.tasks.Task1;

import com.daria.androidDeveloperTest.Task;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by Daria on 05.02.2018.
 */
public class Task1 implements Task {
    private ArrayList<User> users = new ArrayList<User>();
    private Scanner scanner;
    @Override
    public void run() throws FileNotFoundException {
        createUsers();
        System.out.println("Изначальный массив пользователей: ");
        showUsers();
        sortUsers();
        System.out.println('\n' + "Массив пользователей, отсортированный по именам: ");
        showUsers();
    }
    public void createUsers() throws FileNotFoundException {
        // ввод списка пользователей из файла
        //scanner = new Scanner(new File("C:\\Users\\Daria\\com.daria.androidDeveloperTest\\src\\com\\daria\\androidDeveloperTest\\resources\\users.txt"));
        //ввод списка пользователей с консоли в формате "Има Фамилия Возраст"
        scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String input = scanner.nextLine();
            if (input.equals("конец"))
                break;
            int pos1 = input.indexOf(' ');
            int pos2 = input.indexOf(' ', pos1+1);
            String name = input.substring(0, pos1);
            String surname = input.substring(pos1 + 1, pos2);
            String agestr = input.substring(pos2 + 1, input.length());
            int age = str2Int(agestr);
            User user = new User(name, surname, age);
            users.add(user);
        }
        scanner.close();
    }
    public void showUsers(){
        for (User u : users){
            System.out.println(u.toString());
        }
    }

    public int str2Int(String s){ // преобразование строки в число
        int k = 1;
        int res = 0;
        for (int i = s.length() - 1; i >= 0; i--){
            res += (s.charAt(i) - '0') * k;
            k *= 10;
        }
        return res;
    }

    public void sortUsers(){ // сортировка списка пользователей по имени
        Collections.sort(users, new Comparator<User>(){
            @Override
            public int compare(User u1, User u2){
               return u1.getName().compareTo(u2.getName());
            }
        });
    }
}
