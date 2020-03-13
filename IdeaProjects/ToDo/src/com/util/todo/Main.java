package com.util.todo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * This is a ToDo application using the user can customize the tasks
 *
 * @author Viji Radhakrishnan
 * @version 1.0
 */
public class Main {

    //This is the Welcome message when the user starts the application
    public void welcome() {
        System.out.println(">> Welcome to the ToDo Application");
        System.out.println(">> You have X tasks todo and Y tasks are done!");
        System.out.println(">> Pick an option:");
        System.out.println(">> (1) Show Task List (by date or project)");
        System.out.println(">> (2) Add New Task");
        System.out.println(">> (3) Edit Task (update, mark as done, remove)");
        System.out.println(">> (4) Save and Quit");
        System.out.println(">> ");
    }

    //This is the user choice whether to view, add, edit or delete the tasks
    public void userChoice() throws IOException {
        InputStreamReader ir2 = new InputStreamReader(System.in);
        BufferedReader br2 = new BufferedReader(ir2);
        System.out.println("Please make a choice between 1,2,3,4");

        int choice = Integer.parseInt(br2.readLine());
        if (choice == 1) {
            System.out.println("Kindly check the below list of tasks");
            System.out.println("-------------------------------------");
            System.out.println("Created Date: " + "|" + "Task Description: " + "|" + "Category: " + "|" + "Deadline");
            listTask();
            System.out.println("-------------------------------------");
        } else if (choice == 2) {
            System.out.println("Kindly provide the task name, category and deadline details");
            addTask();
        } else if (choice == 3) {
            System.out.println("Kindly choose the task number to edit the same");
            editTask();
        } else
            System.out.println("Save and Quit");
    }

    public void addTask() {

        UserInterface ui = new UserInterface();

        FileAccess fileOutput = new FileAccess();
        fileOutput.accessFile(ui);

        System.out.println("The task information is saved in the file");
    }

    public void listTask() {
        Tasks ti = new Tasks();

        try {
            ti.readTasksFromFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Yet to implement it
    public void editTask() {

    }

    public void nextAction() throws IOException {
        System.out.println("Do you want to continue ? Type Yes OR No");

        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        String str = br.readLine().toLowerCase();

        String yes = "yes";
        if (str.contains(yes)) {
            userChoice();
            nextAction();
        } else {
            System.out.println("Thanks for your visit");
        }
    }

    // Main method
    public static void main(String[] args) throws IOException {

        Main toDo = new Main();
        toDo.welcome();
        toDo.userChoice();
        toDo.nextAction();
    }
}
