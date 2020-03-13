package com.util.todo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.time.LocalDate;

/**
 * This class is used to store the user input in a file
 *
 * @author Viji Radhakrishnan
 * @version 1.0
 */

public class FileAccess {

    //New File declaration and initialization
    File file1 = new File("task.txt");

    //The createdDate field is added automatically when the user adds the tasks
    public void addCreatedDateField() {
        LocalDate createdDate = LocalDate.now();
    }

    //Method to add a file if it does not exist
    //And append the file if it is already exist
    public void accessFile(UserInterface ui3) {
        try {
            FileWriter fw = new FileWriter("task.txt", true);

            //This is the created date field when the user adds the tasks, it will be automatically added in the file
            LocalDate createdDate = LocalDate.now();
            fw.write(String.valueOf(createdDate) + "|");

            SimpleDateFormat format = new SimpleDateFormat("yyyy/mm/dd");
            Date date = format.parse(ui3.dueDate);


            if (!file1.exists()) {
                file1.createNewFile();
                fw.write(ui3.taskDescription + "|");    //the "|" character is added to separate the fields
                fw.write(ui3.category + "|");
                fw.write(date + " " + "\n");

            } else {
                fw.append(ui3.taskDescription + "|");
                fw.append(ui3.category + "|");
                fw.append(date + " " + "\n");
            }
            fw.close();
        } catch (FileNotFoundException e) {
            File file = new File("text.txt");
            System.out.println("The following error occurred " + e);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

}

