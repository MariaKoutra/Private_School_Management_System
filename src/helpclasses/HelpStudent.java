package helpclasses;

import administrator.CheckClass;
import basicclasses.Assignment;
import basicclasses.Student;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class HelpStudent {

    Scanner sc = new Scanner(System.in);
    CheckClass cc = new CheckClass();
    HelpCourse hc = new HelpCourse();
    
    private static ArrayList<Student> listOfAllStudents = new ArrayList<>();
    
       
//********** Create student by scanner **********/
    public Student creatScannerStudent(Scanner sc) {
        System.out.println("Please give the first name of the student:");
        String firstName = sc.nextLine();
        System.out.println("Please give the last name of the student:");
        String lastName = sc.nextLine();
        System.out.println("Please give the date of birth of the student in format \"yyyy-mm-dd\":");
        LocalDate dateOfBirth = cc.checkDate();
        System.out.println("Please give the tuition fees of the student:");
        int tuitionFees = cc.checkInt();
        return new Student(firstName, lastName, dateOfBirth, tuitionFees);
    }
    
//***** return the list with all students ************/
    public ArrayList<Student> getListOfAllStudents() {
        return listOfAllStudents;
    }
    
//** set the list with all students: create a student, add it to list with all students and return this student ***/
    public Student setListOfAllStudents() {
        Student element = creatScannerStudent(sc);
        listOfAllStudents.add(element);
        System.out.println("You just add a " + element.toString());
        System.out.println("\nFound " + getListOfAllStudents().size() + " student(s) now.");
        listOfAllStudents.forEach(System.out::println);
        return element;
    }
 
    public boolean checkStudentInList(Student elementStudent) {
        boolean result = true;
        if (listOfAllStudents.isEmpty()){
            result = true;
        } else {
           for (Student s : getListOfAllStudents()) {
                if (s.getFirstName().equalsIgnoreCase(elementStudent.getFirstName()) 
                        && s.getLastName().equalsIgnoreCase(elementStudent.getLastName())) {
                    result = false;
                    break;
                } else {
                    result = true;
                }
           }
        }
        return result;
    }
    
    public void printIfStudentIsInList (Student elementStudent){
        if ( checkStudentInList(elementStudent) == true){
            listOfAllStudents.add(elementStudent);
            System.out.println("Also, this student added in list of all students because didn't exist..");
        } 
    }
    
    public void printAssignPerStudentInADate(){
        LocalDate[] week = cc.checkDayOfWeek();
            for (Student s : listOfAllStudents) {
                for (Assignment a : s.getListOfAssignmentsPerStudent()) {
                    LocalDate date = a.getSubDateTime();
                    if ( date.isAfter(week[0]) || date.isEqual(week[0]) || date.isBefore(week[1]) || date.isEqual(week[1]) ){
                        System.out.println(s.getFirstName() + " " + s.getLastName() + " has to submite the \"" + a.getTitle() + "\" at \"" + a.getSubDateTime() + "\".");
                        break;
                    } else {
                        System.out.println("There is no student which submite assignment at this week.");
                    }
                }
            }
    }
}
