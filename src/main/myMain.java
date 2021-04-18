package main;

import administrator.ContactWithConsole;
import syntheticdata.SyntheticData;
import java.util.Scanner;

public class myMain {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        ContactWithConsole cwc = new ContactWithConsole();
        SyntheticData sd = new SyntheticData();
        String answerData;
        Boolean wrongAnswer = true;
        System.out.println("Welcome to this private school!!! \n");

        while (wrongAnswer) {                                                                                                          // check if answer is correct
            cwc.askForData();                                                                                                            // ask for input data or synthetic data
            answerData = sc.nextLine();
            
            if (answerData.equalsIgnoreCase("yes")) {                                                                            // input data from user
                wrongAnswer = false;
                cwc.mainMenu();                                                                                                          // show main menu
                
            } else if (answerData.equalsIgnoreCase("no")) {                                                                     // synthetic data
                wrongAnswer = false;
                sd.createCourses();
                sd.createTrainers();
                sd.createStudents();
                sd.createAssignments();
                sd.addTrainersToCourse();
                sd.addStudentsToCourse();
                sd.addAssignmentsToStudent();
                sd.addAssignmentsToCourse();
                cwc.mainMenu();
                
            } else {                                                                                                                          // wrong answer
                System.out.println("Please give one of this options.");
            }
        }
    }
}