package com.daria.androidDeveloperTest;

import java.io.FileNotFoundException;

/**
 * Created by Daria on 05.02.2018.
 */
public abstract class TaskLauncher {
    public static void launch(Task task) throws FileNotFoundException {
        task.run();
    }
}
