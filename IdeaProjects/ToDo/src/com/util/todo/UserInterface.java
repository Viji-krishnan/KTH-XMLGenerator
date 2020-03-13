package com.util.todo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * This class is used to get the input from the user using Keyboard Scanner Class
 *
 * @author Viji Radhakrishnan
 * @version 1.0
 */

public class UserInterface {

    Scanner userInput;
    String category;
    String taskDescription;
    String dueDate;

    public UserInterface() {
        userInput = new Scanner(System.in);
        System.out.println("Enter the Task Description ...");
        taskDescription = userInput.nextLine();
        System.out.println("Enter the lead time to finish the task in the following format yyyy/mm/dd");
        dueDate = userInput.nextLine();
        System.out.println("Enter the Category of the Task ...");
        category = userInput.next();
        System.out.println("Task information is accepted");
    }

    public Date dateFormat() throws ParseException {

        //Get the dueDate field from UserInterface and parse it to match with the correct date format
        SimpleDateFormat format = new SimpleDateFormat("yyyy/mm/dd");
        Date date = format.parse(dueDate);
        return date;
    }
}
