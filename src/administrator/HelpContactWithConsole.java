package administrator;

import basicclasses.Student;
import basicclasses.Trainer;
import basicclasses.Course;
import basicclasses.Assignment;
import helpclasses.HelpAssignment;
import helpclasses.HelpCourse;
import helpclasses.HelpStudent;
import helpclasses.HelpTrainer;
import java.util.Scanner;

public class HelpContactWithConsole {

    Scanner sc = new Scanner(System.in);
    HelpCourse hc = new HelpCourse();
    HelpTrainer ht = new HelpTrainer();
    HelpStudent hs = new HelpStudent();
    HelpAssignment ha = new HelpAssignment();

//****************************** FOR ADD DATA************************************//
//***** Create a trainer from scanner and add this trainer to the course from parameter ************/
    public void addTrainerInCourseFromC(Course elementCourse) {
        Trainer elementTrainer = ht.creatScannerTrainer(sc);
        elementCourse.setListOfTrainersPerCourse(elementCourse, elementTrainer);
        System.out.println("If you want to see the trainers per course, please go to \"Course\" at the \"Main menu\" and press \"yes\".");
    }

//***** Get the answer if insert a trainer in the course from parameter and check the answer ********/
//* if this answer is yes -----> add a trainer in the "elementCourse", ask if will insert an another trainer, get this method again and check the answer */
//* if this answer is no ------> break the while loop */
//* if this answer is wrong ---> ask again and check the answer */
    public void getAnswerTrainerInCourseFromC(String answerC, Course elementCourse) {
        String answerC1;
        boolean wrongAnswerC = true;
        while (wrongAnswerC) {

            if (answerC.equalsIgnoreCase("yes")) {
                wrongAnswerC = false;
                addTrainerInCourseFromC(elementCourse);
                System.out.println("\nDo you want to put an another trainer in this course?\nPlease press \"yes\" or \"no\".");
                answerC1 = sc.nextLine();
                getAnswerTrainerInCourseFromC(answerC1, elementCourse);

            } else if (answerC.equalsIgnoreCase("no")) {
                wrongAnswerC = false;

            } else {
                System.out.println("Please press \"yes\" or \"no\".");
                answerC = sc.nextLine();
            }
        }
    }

//***** Create a student from scanner and add this student to the course from parameter ***********/
    public void addStudentInCourseFromC(Course elementCourse) {
        Student elementStudent = hs.creatScannerStudent(sc);
        elementCourse.setListOfStudentsPerCourse(elementCourse, elementStudent);
        System.out.println("If you want to see the students per course, please go to \"Course\" at the \"Main menu\" and press \"yes\".");
    }

//***** Get the answer if insert a student in the course from parameter and check the answer *******/
//* if this answer is yes -----> add a student in the "elementCourse", ask if it insert an another student, get this method again and check the answer */
//* if this answer is no ------> break the while loop */
//* if this answer is wrong ---> ask again and check the answer */
    public void getAnswerStudentInCourseFromC(String answerS, Course elementCourse) {
        String answerS1;
        boolean wrongAnswerS = true;
        while (wrongAnswerS) {
            if (answerS.equalsIgnoreCase("yes")) {
                wrongAnswerS = false;
                addStudentInCourseFromC(elementCourse);
                System.out.println("\nDo you want to put an another student in this course?\nPlease press \"yes\" or \"no\".");
                answerS1 = sc.nextLine();
                getAnswerStudentInCourseFromC(answerS1, elementCourse);

            } else if (answerS.equalsIgnoreCase("no")) {
                wrongAnswerS = false;

            } else {
                System.out.println("Please press \"yes\" or \"no\".");
                answerS = sc.nextLine();
            }
        }
    }

//******** Create a course from scanner and add the trainer from parameter to this course *********/
    public void addTrainerInCourseFromT(Trainer elementTrainer) {
        Course elementCourse = hc.creatScannerCourse(sc);
        elementCourse.setListOfTrainersPerCourse(elementCourse, elementTrainer);
        System.out.println("If you want to see the trainers per course, please go to \"Course\" at the \"Main menu\" and press \"yes\".");
    }

//***** Get the answer if put the trainer from parameter to a course and check the answer **********/
//* if this answer is yes -----> add the trainer in the course, ask if it will put to an another course, get this method again and check the answer */
//* if this answer is no ------> break the while loop */
//* if this answer is wrong ---> ask again and check the answer */
    public void getAnswerTrainerInCourseFromT(String answerT, Trainer elementTrainer) {
        String answerT1;
        boolean wrongAnswerT = true;
        while (wrongAnswerT) {

            if (answerT.equalsIgnoreCase("yes")) {
                wrongAnswerT = false;
                addTrainerInCourseFromT(elementTrainer);
                System.out.println("\nDo you want to put this trainer in an another course?\nPlease press \"yes\" or \"no\".");
                answerT1 = sc.nextLine();
                getAnswerTrainerInCourseFromT(answerT1, elementTrainer);

            } else if (answerT.equalsIgnoreCase("no")) {
                wrongAnswerT = false;

            } else {
                System.out.println("Please press \"yes\" or \"no\".");
                answerT = sc.nextLine();
            }
        }
    }

//*************************** Add From HelpAssignment*********************************//

    public void addAssignmentInStudentFromA(Assignment elementAssignment) {
        Student elementStudent = hs.creatScannerStudent(sc);
        elementStudent.setListOfAssignmentsPerStudent(elementStudent, elementAssignment);
        System.out.println("If you want to see the assignments per student, please go to \"Student\" at the \"Main menu\" and press \"yes\".");
    }

    public void getAnswerAssignmentInStudentFromA(String answerA, Assignment elementAssignment) {
        String answerA1;
        boolean wrongAnswerA = true;
        while (wrongAnswerA) {
            if (answerA.equalsIgnoreCase("yes")) {
                wrongAnswerA = false;
                addAssignmentInStudentFromA(elementAssignment);
                System.out.println("\nDo you want to put this assignment in an another student?\nPlease press \"yes\" or \"no\".");
                answerA1 = sc.nextLine();
                getAnswerAssignmentInStudentFromA(answerA1, elementAssignment);

            } else if (answerA.equalsIgnoreCase("no")) {
                wrongAnswerA = false;
            } else {
                System.out.println("Please press \"yes\" or \"no\".");
                answerA = sc.nextLine();
            }
        }
    }

    public void getAnswerSetMarkInAssignment(String answerMark) {
        while (true) {
            if (answerMark.equalsIgnoreCase("yes")){
                ha.setMarkInAssignment();
                break;

            } else if (answerMark.equalsIgnoreCase("no")) {
                break;

            } else {
                System.out.println("Please press \"yes\" or \"no\".");
                answerMark = sc.nextLine();
            }
        }
    }
    
    public void getAnswerAddAssignment(String answerAdd) {
        while (true) {
            if (answerAdd.equalsIgnoreCase("yes")){
                Assignment elementAssignment = ha.setListOfAllAssignment();
                
                System.out.println("\nDo you want to put this assignment to a student?\nPlease press \"yes\" or \"no\".");
                String answer = sc.nextLine();
                getAnswerAssignmentInStudentFromA(answer, elementAssignment);
                break;

            } else if (answerAdd.equalsIgnoreCase("no")) {
                break;

            } else {
                System.out.println("Please press \"yes\" or \"no\".");
                answerAdd = sc.nextLine();
            }
        }
    }

    public void addStudentInCourseFromS(Student elementStudent) {
        Course elementCourse = hc.creatScannerCourse(sc);
        elementCourse.setListOfStudentsPerCourse(elementCourse, elementStudent);
        System.out.println("If you want to see the students per course, please go to \"Course\" in the \"Main menu\" and press \"yes\".");
    }

    public void getAnswerStudentsInCourseFromS(String answerS, Student elementStudent) {
        String answerS1;
        boolean wrongAnswerS = true;
        while (wrongAnswerS) {
            if (answerS.equalsIgnoreCase("yes")) {
                wrongAnswerS = false;
                addStudentInCourseFromS(elementStudent);
                System.out.println("\nDo you want to put this student in an another course?\nPlease press \"yes\" or \"no\".");
                answerS1 = sc.nextLine();
                getAnswerStudentsInCourseFromS(answerS1, elementStudent);

            } else if (answerS.equalsIgnoreCase("no")) {
                wrongAnswerS = false;

            } else {
                System.out.println("Please press \"yes\" or \"no\".");
                answerS = sc.nextLine();
            }
        }
    }

//***** create an assignment from scanner and add this assignment to the student from parameter */
    public void addAssignmentInStudentFromS(Student elementStudent) {
        Assignment elementAssignment = ha.creatScannerAssignment(sc);
        elementStudent.setListOfAssignmentsPerStudent(elementStudent, elementAssignment);
        System.out.println("If you want to see the assignments per student, please go to \"Student\" at the \"Main menu\" and press \"yes\".");
    }

//**** Get the answer if insert an assignment in the student from parameter and check the answer ****/
//* if this answer is yes -----> add an assignment in the "elementStudent", ask if it insert an another assignment, get this method again and check the answer */
//* if this answer is no ------> break the while loop */
//* if this answer is wrong ---> ask again and check the answer */
    public void getAnswerAssignmentInStudentFromS(String answerA, Student elementStudent) {
        String answerA1;
        boolean wrongAnswerA = true;
        while (wrongAnswerA) {
            if (answerA.equalsIgnoreCase("yes")) {
                wrongAnswerA = false;
                addAssignmentInStudentFromS(elementStudent);
                System.out.println("\nDo you want to put an another assignment in this student?\nPlease press \"yes\" or \"no\".");
                answerA1 = sc.nextLine();
                getAnswerAssignmentInStudentFromS(answerA1, elementStudent);

            } else if (answerA.equalsIgnoreCase("no")) {
                wrongAnswerA = false;
            } else {
                System.out.println("Please press \"yes\" or \"no\".");
                answerA = sc.nextLine();
            }
        }
    }

//*************************** FOR SHOW DATA *************************************//
    public void printListOfAllTrainers() {
        if (ht.getListOfAllTrainers().isEmpty()) {
            System.out.println("There is no trainers now.");
        } else {
            ht.getListOfAllTrainers().forEach(System.out::println);
            System.out.println("If you want to see the trainers per course, please go to \"Course\" at the \"Main menu\" and press \"yes\".");
        }
    }

    public void printListOfAllAssignments() {
        if (ha.getListOfAllAssignments().isEmpty()) {
            System.out.println("There is no assignments now.");
        } else {
            ha.getListOfAllAssignments().forEach(System.out::println);
            System.out.println("If you want to see the assignments per student, please go to \"Student\" at the \"Main menu\" and press \"yes\".");
        }
    }

    public void getAnswerShowC(String answer) {
        boolean wrongAnswer = true;
        while (wrongAnswer) {

            if (answer.equalsIgnoreCase("course")) {
                wrongAnswer = false;
                printListOfAllCourses();

            } else if (answer.equalsIgnoreCase("student")) {
                wrongAnswer = false;
                prinListOfStudentPerCourse();

            } else if (answer.equalsIgnoreCase("trainer")) {
                wrongAnswer = false;
                printListOfTrainersPerCourse();

            } else if (answer.equalsIgnoreCase("assignment")){
                wrongAnswer = false;
                prinListOfAssignmentsPerCourse();
                
            } else {
                System.out.println("Please press \"course\", \"student\", \"trainer\" or \"assignment\".");
                answer = sc.nextLine();
            }
        }
    }

    public void printListOfAllCourses() {
        if (hc.getListOfAllCourses().isEmpty()) {
            System.out.println("There is no courses now.");
        } else {
            System.out.println("\nFound " + hc.getListOfAllCourses().size() + " courses totally.");
            hc.getListOfAllCourses().forEach(System.out::println);
        }
    }

    public void prinListOfStudentPerCourse() {
        if (hc.getListOfAllCourses().isEmpty()) {
            System.out.println("There is no students because there is no courses now.");
        } else {
            for (Course c : hc.getListOfAllCourses()) {
                System.out.println("\nFound " + c.getListOfStudentsPerCourse().size() + " students in " + c.toString() + ": ");
                c.getListOfStudentsPerCourse().forEach(System.out::println);
            }
        }
    }

    public void printListOfTrainersPerCourse() {
        if (hc.getListOfAllCourses().isEmpty()) {
            System.out.println("There is no trainers because there is no courses now.");
        } else {
            for (Course c : hc.getListOfAllCourses()) {
                System.out.println("\nFound " + c.getListOfTrainersPerCourse().size() + " trainers in " + c.toString() + ": ");
                c.getListOfTrainersPerCourse().forEach(System.out::println);
            }
        }
    }
    
     public void prinListOfAssignmentsPerCourse() {
        if (hc.getListOfAllCourses().isEmpty()) {
            System.out.println("There is no assignments because there is no courses now.");
        } else {
            for (Course c : hc.getListOfAllCourses()) {
                System.out.println("\nFound " + c.getListOfAssignmentsPerCourse().size() + " assignments in " + c.toString() + ": ");
                c.getListOfAssignmentsPerCourse().forEach(System.out::println);
            }
        }
    }

    public void getAnswerShowS(String answer) {
        boolean wrongAnswer = true;
        while (wrongAnswer) {

            if (answer.equalsIgnoreCase("student")) {
                wrongAnswer = false;
                printListOfAllStudents();

            } else if (answer.equalsIgnoreCase("assignment")) {
                wrongAnswer = false;
                printListOfAssignmentsPerStudent();

            } else if (answer.equalsIgnoreCase("date")) {
                wrongAnswer = false;
                hs.printAssignPerStudentInADate();

            } else if (answer.equalsIgnoreCase("more")){
                wrongAnswer = false;
                printStudentsInManyCourses();
              
            } else {
                System.out.println("Please press \"student\", \"assignment\" or \"date\".");
                answer = sc.nextLine();
            }
        }
    }

    public void printListOfAllStudents() {
        if (hs.getListOfAllStudents().isEmpty()) {
            System.out.println("There is no students now");
        } else {
            System.out.println("\nFound " + hs.getListOfAllStudents().size() + " students totally.");
            hs.getListOfAllStudents().forEach(System.out::println);
            System.out.println("If you want to see the students per course, please go to \"Course\" at the \"Main menu\" and press \"yes\".");
        }
    }

    public void printListOfAssignmentsPerStudent() {
        if (hs.getListOfAllStudents().isEmpty()) {
            System.out.println("There is no assignments because there is no students now.");
        } else {
            for (Student s : hs.getListOfAllStudents()) {
                System.out.println("\nFound " + s.getListOfAssignmentsPerStudent().size() + " assignments in " + s.toString() + ": ");
                s.getListOfAssignmentsPerStudent().forEach(System.out::println);
            }
        }
    }
    
    public void printStudentsInManyCourses() {
        for (Student s : hs.getListOfAllStudents()) {
            int count = 0;
            for (Course c : hc.getListOfAllCourses()) {
                for (Student s1 : c.getListOfStudentsPerCourse()) {
                    if (s1 == s) {
                        count++;
                    }
                }
            }
            if (count > 1){
                System.out.println(s.getFirstName() + " " + s.getLastName() + " belong in more than one course.");
            }
        }
    }
}
