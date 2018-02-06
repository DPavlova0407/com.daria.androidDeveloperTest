package com.daria.androidDeveloperTest;

import com.daria.androidDeveloperTest.tasks.Task2.Task2;

import java.io.FileNotFoundException;

/**
 * Created by Daria on 05.02.2018.
 */
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        //TaskLauncher.launch(new Task1());
        TaskLauncher.launch(new Task2());
        //TaskLauncher.launch(new Task3());
    }
}
