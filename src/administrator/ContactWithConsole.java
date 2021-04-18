package administrator;

import helpclasses.HelpTrainer;
import helpclasses.HelpStudent;
import helpclasses.HelpCourse;
import helpclasses.HelpAssignment;
import basicclasses.Course;
import basicclasses.Student;
import basicclasses.Trainer;
import java.util.Scanner;

public class ContactWithConsole {

    Scanner sc = new Scanner(System.in);
    HelpCourse hc = new HelpCourse();
    HelpTrainer ht = new HelpTrainer();
    HelpStudent hs = new HelpStudent();
    HelpAssignment ha = new HelpAssignment();
    HelpContactWithConsole hcwc = new HelpContactWithConsole();

    public void askForData() {
        System.out.println("Do you want to insert data?\nPlease press \"yes\" to continue or press \"no\" to synthetic data automaticaly.\nWhich is your response?");
    }

    public void askWhatDo() {
        System.out.println("If you want to add a new entry, please press \"add\".");
        System.out.println("If you want to see all together, please press \"yes\" else press \"no\" to return at the main menu.\nWhich is your response?");
    }

    public void mainMenu() { // Καθε φορα εμφανιζεται και αποθηκευεται στο answerMenu
        System.out.println("         Main menu");
        System.out.println("If you want go to Courses, please press \"c\".");
        System.out.println("If you want go to Students, please press \"s\".");
        System.out.println("If you want go to Trainers, please press \"t\".");
        System.out.println("If you want go to Assignments, please press \"a\".");
        System.out.println("If you want to exit from program, please press \"e\".\nWhich is your response?");
        String answer = sc.nextLine();
        getAnswerMenu(answer);
    }

    public void getAnswerMenu(String answerMenu) {
        switch (answerMenu) {
            case "s": // Case Student
            case "S":
                askWhatDo();
                String answerStudent = sc.nextLine();
                getAnswerPerStudent(answerStudent);

                break;
            case "t":  // Case Trainer
            case "T":
                askWhatDo();
                String answerTrainer = sc.nextLine();
                getAnswerPerTrainer(answerTrainer);

                break;
            case "c":  // Case Course
            case "C":
                askWhatDo();
                String answerCourse = sc.nextLine();
                getAnswerPerCourse(answerCourse);

                break;
            case "a":  // Case Assignments
            case "A":
                askWhatDo();
                String answerAssignment = sc.nextLine();
                getAnswerPerAssignment(answerAssignment);

                break;

            case "e":   // Case exit : terminate
            case "E":

                break;
            default:
                System.out.println("Please give one of this options.");
                mainMenu();
                break;
        }

    }

//***** Get the answer if add a course or if see the courses ("yes") or if go to main menu ("no") ******/
//* If this answer is "add" ---> add a course, add it in list with all courses and return this course in "elementCourse" */
//*                            |----> ask if insert a trainer in this course, get this answer and go to that method  * /
//*                            |----> ask if insert a student in this course, get this answer and go to that method  */
//*                            |----> ask again what will doing and go to this method for check the new answer */
//* If this answer is "yes" ---> */
//* If this answer is "no" ----> go to main menu */
//* If this answer is wrong --> ask again and go to this method for check the answer */
    public void getAnswerPerCourse(String answerCourse) {
        boolean wrong = true;
        while (wrong) {
            if (answerCourse.equalsIgnoreCase("add")) {

                wrong = false;
                Course elementCourse = hc.setListOfAllCourses();

                System.out.println("\nDo you want to put a trainer in this course?\nPlease press \"yes\" or \"no\".");
                String answerC = sc.nextLine();
                hcwc.getAnswerTrainerInCourseFromC(answerC, elementCourse);

                System.out.println("\nDo you want to put a student in this course?\nPlease press \"yes\" or \"no\".");
                String answerS = sc.nextLine();
                hcwc.getAnswerStudentInCourseFromC(answerS, elementCourse);

                System.out.println("\nYou are at the course details now.");
                askWhatDo();
                String answerDo1 = sc.nextLine();
                getAnswerPerCourse(answerDo1);

            } else if (answerCourse.equalsIgnoreCase("yes")) {
                wrong = false;

                System.out.println("If you want to see all courses, please press \"course\".\n"
                        + "If you want to see all students per course, please press \"student\".\n"
                        + "If you want to see all trainers per course, please press \"trainer\".\n"
                        + "If you want to see all assignments per course, please press \"assignment\".");
                String answer = sc.nextLine();
                hcwc.getAnswerShowC(answer);

                System.out.println("\nYou are at the courses details now.");
                askWhatDo();
                String answerDo2 = sc.nextLine();
                getAnswerPerCourse(answerDo2);

            } else if (answerCourse.equalsIgnoreCase("no")) {
                wrong = false;
                mainMenu();

            } else {
                System.out.println("\nYou are at the course's details now.\nPlease give one of this options.");
                askWhatDo();
                answerCourse = sc.nextLine();
            }
        }
    }

    public void getAnswerPerTrainer(String answerTrainer) {
        boolean wrong = true;
        while (wrong) {

            if (answerTrainer.equalsIgnoreCase("add")) {
                wrong = false;
                Trainer elementTrainer = ht.setListOfAllTrainers();

                System.out.println("\nDo you want to put this trainer to a course?\nPlease press \"yes\" or \"no\".");
                String answerT = sc.nextLine();
                hcwc.getAnswerTrainerInCourseFromT(answerT, elementTrainer);

                System.out.println("\nYou are at the trainer's details now.");
                askWhatDo();
                String answerDo1 = sc.nextLine();
                getAnswerPerTrainer(answerDo1);

            } else if (answerTrainer.equalsIgnoreCase("yes")) {
                wrong = false;

                hcwc.printListOfAllTrainers();

                System.out.println("\nYou are at the trainer's details now.");
                askWhatDo();
                String answerDo2 = sc.nextLine();
                getAnswerPerTrainer(answerDo2);

            } else if (answerTrainer.equalsIgnoreCase("no")) {
                wrong = false;
                mainMenu();

            } else {
                System.out.println("\nYou are at the trainers details now.\nPlease give one of this options.");
                askWhatDo();
                answerTrainer = sc.nextLine();
            }
        }
    }

    public void getAnswerPerStudent(String answerStudent) {
        boolean wrong = true;
        while (wrong) {
            if (answerStudent.equalsIgnoreCase("add")) {

                wrong = false;
                Student elementStudent = hs.setListOfAllStudents();

                System.out.println("\nDo you want to put this student to a course?\nPlease press \"yes\" or \"no\".");
                String answerS = sc.nextLine();
                hcwc.getAnswerStudentsInCourseFromS(answerS, elementStudent);

                System.out.println("\nDo you want to put an assignment in this student?\nPlease press \"yes\" or \"no\".");
                String answerA = sc.nextLine();
                hcwc.getAnswerAssignmentInStudentFromS(answerA, elementStudent);

                System.out.println("\nYou are at the students details now.");
                askWhatDo();
                String answerDo1 = sc.nextLine();
                getAnswerPerStudent(answerDo1);

            } else if (answerStudent.equalsIgnoreCase("yes")) {
                wrong = false;

                System.out.println("If you want to see all students, please press \"student\".\n"
                        + "If you want to see all assignments per student, please press \"assignment\".\n"
                        + "If you want to see all students which submite an assignment in a specific date, please press \"date\".\n"
                        + "If you want to see all students which belong in more than one course, please press \"more\".");
                String answer = sc.nextLine();
                hcwc.getAnswerShowS(answer);

                System.out.println("\nYou are at the students details now.");
                askWhatDo();
                String answerDo2 = sc.nextLine();
                getAnswerPerStudent(answerDo2);

            } else if (answerStudent.equalsIgnoreCase("no")) {
                wrong = false;
                mainMenu();

            } else {
                System.out.println("\nYou are at the students details now.\nPlease give one of this options.");
                askWhatDo();
                answerStudent = sc.nextLine();
            }
        }
    }

    public void getAnswerPerAssignment(String answerAssignment) {
        boolean wrong = true;
        while (wrong) {
            if (answerAssignment.equalsIgnoreCase("add")) {
                wrong = false;
                System.out.println("\nDo you want to add an assignment?\nPlease press \"yes\" or \"no\".");
                String answerAdd = sc.nextLine();
                hcwc.getAnswerAddAssignment(answerAdd);
                
                System.out.println("\nDo you want to set the marks of a assignment?\nPlease press \"yes\" or \"no\".");
                String answerMark = sc.nextLine();
                hcwc.getAnswerSetMarkInAssignment(answerMark);

                System.out.println("\nYou are at the assignments details now.");
                askWhatDo();
                String answerDo1 = sc.nextLine();
                getAnswerPerAssignment(answerDo1);

            } else if (answerAssignment.equalsIgnoreCase("yes")) {
                wrong = false;

                hcwc.printListOfAllAssignments();

                System.out.println("\nYou are at the assignments details now.");
                askWhatDo();
                String answerDo2 = sc.nextLine();
                getAnswerPerAssignment(answerDo2);

            } else if (answerAssignment.equalsIgnoreCase("no")) {
                wrong = false;
                mainMenu();

            } else {
                System.out.println("\nYou are at the assignments details now.\nPlease give one of this options.");
                askWhatDo();
                answerAssignment = sc.nextLine();
            }
        }
    }
}
