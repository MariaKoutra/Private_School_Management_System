package basicclasses;

import administrator.CheckClass;
import helpclasses.HelpAssignment;
import helpclasses.HelpStudent;
import java.time.LocalDate;
import java.util.ArrayList;

public class Student {

    HelpAssignment ha = new HelpAssignment();
    HelpStudent hs = new HelpStudent();
    CheckClass cc = new CheckClass();

    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private int tuitionFees;
    private ArrayList<Assignment> listOfAssignmentsPerStudent;

    public Student(String firstName, String lastName, LocalDate dateOfBirth, int tuitionFees) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.tuitionFees = tuitionFees;
        listOfAssignmentsPerStudent = new ArrayList<>();            // a list with assignments for each student 
    }

    @Override
    public String toString() {
        return "Student:{" + "first name=" + firstName + ", last name=" + lastName + ", date of birth=" + dateOfBirth + ", tuition fees=" + tuitionFees + '}';
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getTuitionFees() {
        return tuitionFees;
    }

    public void setTuitionFees(int tuitionFees) {
        this.tuitionFees = tuitionFees;
    }

//***** return the list with all assignments for each student *****//
    public ArrayList<Assignment> getListOfAssignmentsPerStudent() {
        return listOfAssignmentsPerStudent;
    }

//***** Get a student and an assignment from parameter and put this assignment to this student *****//
    public void setListOfAssignmentsPerStudent(Student elementStudent, Assignment elementAssignment) {
        ha.checkAssignmentInList(elementAssignment);
        ha.printIfAssignmentIsInList(elementAssignment);
        hs.checkStudentInList(elementStudent);
        hs.printIfStudentIsInList(elementStudent);
        elementStudent.getListOfAssignmentsPerStudent().add(elementAssignment);
        System.out.println("You just add an " + elementAssignment.toString() + " in " + elementStudent.toString());
    }


}
