package com.util.todo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * This is a tasks class using which the user can add, edit, delete his todo tasks
 *
 * @author Viji Radhakrishnan
 * @version 1.0
 */
public class Tasks {

    List<UserInterface> toDoList;
    // Iterator<> itr1;
    int taskNo = 1;

    //Constructor
    public Tasks() {
        toDoList = new ArrayList<UserInterface>();
        //itr1 = toDoList.iterator();
    }

    /*To add a new ToDo tasks using values from Input Class
     * Including a field called taskNo in each task list, this is used to track the tasks and edit it
     */

    // In Progress... working on it
    public void addList(UserInterface objIo) {
        int taskNumber = 1;
        int arraySize = toDoList.size();

        if (taskNumber == arraySize) {
            toDoList.add(taskNumber, objIo);
        }
        System.out.println("The array is ready");
    }

    //This method reads the file strings and list it in the terminal for the user
    public void readTasksFromFile() throws IOException {

        FileReader fileReader = new FileReader("task.txt");
        BufferedReader br1 = new BufferedReader(fileReader);
        String line = br1.readLine();
        while (line != null) {
            System.out.println(line);
            line = br1.readLine();
        }
        br1.close();
    }
}




