package syntheticdata;

import helpclasses.HelpTrainer;
import helpclasses.HelpStudent;
import helpclasses.HelpCourse;
import helpclasses.HelpAssignment;
import basicclasses.Student;
import basicclasses.Trainer;
import basicclasses.Course;
import basicclasses.Assignment;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class SyntheticData {

    HelpTrainer ht = new HelpTrainer();
    HelpStudent hs = new HelpStudent();
    HelpCourse hc = new HelpCourse();
    HelpAssignment ha = new HelpAssignment();
    LocalDate lc = LocalDate.parse("2020-10-15", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    LocalDate lc1 = LocalDate.parse("2020-11-11", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    LocalDate lc2 = LocalDate.parse("2020-12-23", DateTimeFormatter.ofPattern("yyyy-MM-dd"));

    public void createTrainers() {
        ht.getListOfAllTrainers().add(new Trainer("Vaso", "Badourou", "Java"));
        ht.getListOfAllTrainers().add(new Trainer("Xristos", "Kapopoulos", "Kotlin"));
        ht.getListOfAllTrainers().add(new Trainer("Makis", "Arseniou", "JavaScript"));
        ht.getListOfAllTrainers().add(new Trainer("Stelios", "Stergiou", "Python"));
        ht.getListOfAllTrainers().add(new Trainer("Anna", "Papadatou", "C++"));
    }

    public void createStudents() {
        hs.getListOfAllStudents().add(new Student("Maria", "Koutra", LocalDate.parse("1997-01-04", DateTimeFormatter.ofPattern("yyyy-MM-dd")), 1000));
        hs.getListOfAllStudents().add(new Student("Tasos", "Kladis", LocalDate.parse("1996-11-27", DateTimeFormatter.ofPattern("yyyy-MM-dd")), 1000));
        hs.getListOfAllStudents().add(new Student("Katerina", "Kitsou", LocalDate.parse("2001-03-13", DateTimeFormatter.ofPattern("yyyy-MM-dd")), 1000));
        hs.getListOfAllStudents().add(new Student("Andreas", "Strebelias", lc, 1000));
        hs.getListOfAllStudents().add(new Student("Petros", "Petrou", lc, 1000));
        hs.getListOfAllStudents().add(new Student("Alexia", "Papadatou", lc2, 1000));
        hs.getListOfAllStudents().add(new Student("Fotis", "Papadopoulos", lc, 1000));
        hs.getListOfAllStudents().add(new Student("Giorgos", "Koletis", lc2, 1000));
        hs.getListOfAllStudents().add(new Student("Fanis", "Xristakopoulos", lc, 1000));
        hs.getListOfAllStudents().add(new Student("Sofia", "Kolosaka", lc1, 1000));
        hs.getListOfAllStudents().add(new Student("Xrisa", "Koloka", lc1, 1000));
        hs.getListOfAllStudents().add(new Student("Eleni", "Mitropoulou", lc1, 1000));
        hs.getListOfAllStudents().add(new Student("Eirini", "Kamaledaki", lc, 1000));
        hs.getListOfAllStudents().add(new Student("Margarita", "Stratigi", lc1, 1000));
        hs.getListOfAllStudents().add(new Student("Marianna", "Tourlaki", lc2, 1000));
    }

    public void createCourses() {
        hc.getListOfAllCourses().add(new Course("CB12 Java", "Java", "Part Time", lc, lc1));
        hc.getListOfAllCourses().add(new Course("CB12 Java", "Java", "Full Time", lc, lc1));
        hc.getListOfAllCourses().add(new Course("CB12 Python", "Python", "Part Time", lc1, lc2));
        hc.getListOfAllCourses().add(new Course("CB12 C++", "C++", "Part Time", lc1, lc2));
        hc.getListOfAllCourses().add(new Course("CB12 C++", "C++", "Full Time", lc, lc2));
    }

    public void createAssignments() {
        ha.getListOfAllAssignments().add(new Assignment("Project1", "Private school", lc, 0, 0));
        ha.getListOfAllAssignments().add(new Assignment("Project2", "Teamwork project", lc1, 0, 0));
        ha.getListOfAllAssignments().add(new Assignment("Project3", "Intividual project", lc2, 0, 0));
        ha.getListOfAllAssignments().add(new Assignment("Project4", "Pet shop", lc1, 0, 0));
        ha.getListOfAllAssignments().add(new Assignment("Project5", "Library", lc2, 0, 0));
    }

    public void addTrainersToCourse() {
        hc.getListOfAllCourses().get(0).getListOfTrainersPerCourse().add(ht.getListOfAllTrainers().get(0));
        hc.getListOfAllCourses().get(0).getListOfTrainersPerCourse().add(ht.getListOfAllTrainers().get(1));
        hc.getListOfAllCourses().get(0).getListOfTrainersPerCourse().add(ht.getListOfAllTrainers().get(2));
        hc.getListOfAllCourses().get(0).getListOfTrainersPerCourse().add(ht.getListOfAllTrainers().get(4));
        hc.getListOfAllCourses().get(1).getListOfTrainersPerCourse().add(ht.getListOfAllTrainers().get(1));
        hc.getListOfAllCourses().get(1).getListOfTrainersPerCourse().add(ht.getListOfAllTrainers().get(3));
        hc.getListOfAllCourses().get(1).getListOfTrainersPerCourse().add(ht.getListOfAllTrainers().get(4));
        hc.getListOfAllCourses().get(2).getListOfTrainersPerCourse().add(ht.getListOfAllTrainers().get(2));
        hc.getListOfAllCourses().get(2).getListOfTrainersPerCourse().add(ht.getListOfAllTrainers().get(3));
        hc.getListOfAllCourses().get(3).getListOfTrainersPerCourse().add(ht.getListOfAllTrainers().get(3));
        hc.getListOfAllCourses().get(3).getListOfTrainersPerCourse().add(ht.getListOfAllTrainers().get(1));
        hc.getListOfAllCourses().get(4).getListOfTrainersPerCourse().add(ht.getListOfAllTrainers().get(4));
    }
    
     public void addAssignmentsToCourse(){
          hc.getListOfAllCourses().get(0).getListOfAssignmentsPerCourse().add(ha.getListOfAllAssignments().get(0));
          hc.getListOfAllCourses().get(0).getListOfAssignmentsPerCourse().add(ha.getListOfAllAssignments().get(1));
          hc.getListOfAllCourses().get(0).getListOfAssignmentsPerCourse().add(ha.getListOfAllAssignments().get(2));
          hc.getListOfAllCourses().get(0).getListOfAssignmentsPerCourse().add(ha.getListOfAllAssignments().get(3));
          hc.getListOfAllCourses().get(1).getListOfAssignmentsPerCourse().add(ha.getListOfAllAssignments().get(0));
          hc.getListOfAllCourses().get(1).getListOfAssignmentsPerCourse().add(ha.getListOfAllAssignments().get(3));
          hc.getListOfAllCourses().get(2).getListOfAssignmentsPerCourse().add(ha.getListOfAllAssignments().get(4));
          hc.getListOfAllCourses().get(3).getListOfAssignmentsPerCourse().add(ha.getListOfAllAssignments().get(1));
          hc.getListOfAllCourses().get(3).getListOfAssignmentsPerCourse().add(ha.getListOfAllAssignments().get(4));
          hc.getListOfAllCourses().get(4).getListOfAssignmentsPerCourse().add(ha.getListOfAllAssignments().get(0));
          hc.getListOfAllCourses().get(4).getListOfAssignmentsPerCourse().add(ha.getListOfAllAssignments().get(2));
     }

    public void addStudentsToCourse() {
        hc.getListOfAllCourses().get(0).getListOfStudentsPerCourse().add(hs.getListOfAllStudents().get(0));
        hc.getListOfAllCourses().get(0).getListOfStudentsPerCourse().add(hs.getListOfAllStudents().get(1));
        hc.getListOfAllCourses().get(0).getListOfStudentsPerCourse().add(hs.getListOfAllStudents().get(2));
        hc.getListOfAllCourses().get(0).getListOfStudentsPerCourse().add(hs.getListOfAllStudents().get(3));
        hc.getListOfAllCourses().get(0).getListOfStudentsPerCourse().add(hs.getListOfAllStudents().get(4));
        hc.getListOfAllCourses().get(0).getListOfStudentsPerCourse().add(hs.getListOfAllStudents().get(5));
        hc.getListOfAllCourses().get(1).getListOfStudentsPerCourse().add(hs.getListOfAllStudents().get(3));
        hc.getListOfAllCourses().get(1).getListOfStudentsPerCourse().add(hs.getListOfAllStudents().get(4));
        hc.getListOfAllCourses().get(1).getListOfStudentsPerCourse().add(hs.getListOfAllStudents().get(5));
        hc.getListOfAllCourses().get(1).getListOfStudentsPerCourse().add(hs.getListOfAllStudents().get(6));
        hc.getListOfAllCourses().get(2).getListOfStudentsPerCourse().add(hs.getListOfAllStudents().get(6));
        hc.getListOfAllCourses().get(2).getListOfStudentsPerCourse().add(hs.getListOfAllStudents().get(7));
        hc.getListOfAllCourses().get(2).getListOfStudentsPerCourse().add(hs.getListOfAllStudents().get(8));
        hc.getListOfAllCourses().get(2).getListOfStudentsPerCourse().add(hs.getListOfAllStudents().get(11));
        hc.getListOfAllCourses().get(3).getListOfStudentsPerCourse().add(hs.getListOfAllStudents().get(9));
        hc.getListOfAllCourses().get(3).getListOfStudentsPerCourse().add(hs.getListOfAllStudents().get(10));
        hc.getListOfAllCourses().get(3).getListOfStudentsPerCourse().add(hs.getListOfAllStudents().get(11));
        hc.getListOfAllCourses().get(3).getListOfStudentsPerCourse().add(hs.getListOfAllStudents().get(12));
        hc.getListOfAllCourses().get(3).getListOfStudentsPerCourse().add(hs.getListOfAllStudents().get(13));
        hc.getListOfAllCourses().get(3).getListOfStudentsPerCourse().add(hs.getListOfAllStudents().get(4));
        hc.getListOfAllCourses().get(3).getListOfStudentsPerCourse().add(hs.getListOfAllStudents().get(14));
        hc.getListOfAllCourses().get(4).getListOfStudentsPerCourse().add(hs.getListOfAllStudents().get(8));
        hc.getListOfAllCourses().get(4).getListOfStudentsPerCourse().add(hs.getListOfAllStudents().get(9));
        hc.getListOfAllCourses().get(4).getListOfStudentsPerCourse().add(hs.getListOfAllStudents().get(10));
        hc.getListOfAllCourses().get(4).getListOfStudentsPerCourse().add(hs.getListOfAllStudents().get(12));
        hc.getListOfAllCourses().get(4).getListOfStudentsPerCourse().add(hs.getListOfAllStudents().get(13));
        hc.getListOfAllCourses().get(4).getListOfStudentsPerCourse().add(hs.getListOfAllStudents().get(14));
    }

    public void addAssignmentsToStudent() {
        hs.getListOfAllStudents().get(0).getListOfAssignmentsPerStudent().add(ha.getListOfAllAssignments().get(0));
        hs.getListOfAllStudents().get(0).getListOfAssignmentsPerStudent().add(ha.getListOfAllAssignments().get(1));
        hs.getListOfAllStudents().get(0).getListOfAssignmentsPerStudent().add(ha.getListOfAllAssignments().get(2));
        hs.getListOfAllStudents().get(1).getListOfAssignmentsPerStudent().add(ha.getListOfAllAssignments().get(0));
        hs.getListOfAllStudents().get(1).getListOfAssignmentsPerStudent().add(ha.getListOfAllAssignments().get(2));
        hs.getListOfAllStudents().get(1).getListOfAssignmentsPerStudent().add(ha.getListOfAllAssignments().get(3));
        hs.getListOfAllStudents().get(2).getListOfAssignmentsPerStudent().add(ha.getListOfAllAssignments().get(0));
        hs.getListOfAllStudents().get(2).getListOfAssignmentsPerStudent().add(ha.getListOfAllAssignments().get(1));
        hs.getListOfAllStudents().get(2).getListOfAssignmentsPerStudent().add(ha.getListOfAllAssignments().get(2));
        hs.getListOfAllStudents().get(3).getListOfAssignmentsPerStudent().add(ha.getListOfAllAssignments().get(2));
        hs.getListOfAllStudents().get(3).getListOfAssignmentsPerStudent().add(ha.getListOfAllAssignments().get(3));
        hs.getListOfAllStudents().get(3).getListOfAssignmentsPerStudent().add(ha.getListOfAllAssignments().get(4));
        hs.getListOfAllStudents().get(4).getListOfAssignmentsPerStudent().add(ha.getListOfAllAssignments().get(0));
        hs.getListOfAllStudents().get(4).getListOfAssignmentsPerStudent().add(ha.getListOfAllAssignments().get(1));
        hs.getListOfAllStudents().get(4).getListOfAssignmentsPerStudent().add(ha.getListOfAllAssignments().get(2));
        hs.getListOfAllStudents().get(4).getListOfAssignmentsPerStudent().add(ha.getListOfAllAssignments().get(3));
        hs.getListOfAllStudents().get(5).getListOfAssignmentsPerStudent().add(ha.getListOfAllAssignments().get(1));
        hs.getListOfAllStudents().get(5).getListOfAssignmentsPerStudent().add(ha.getListOfAllAssignments().get(3));
        hs.getListOfAllStudents().get(6).getListOfAssignmentsPerStudent().add(ha.getListOfAllAssignments().get(2));
        hs.getListOfAllStudents().get(6).getListOfAssignmentsPerStudent().add(ha.getListOfAllAssignments().get(3));
        hs.getListOfAllStudents().get(6).getListOfAssignmentsPerStudent().add(ha.getListOfAllAssignments().get(4));
        hs.getListOfAllStudents().get(7).getListOfAssignmentsPerStudent().add(ha.getListOfAllAssignments().get(0));
        hs.getListOfAllStudents().get(7).getListOfAssignmentsPerStudent().add(ha.getListOfAllAssignments().get(2));
        hs.getListOfAllStudents().get(8).getListOfAssignmentsPerStudent().add(ha.getListOfAllAssignments().get(3));
        hs.getListOfAllStudents().get(8).getListOfAssignmentsPerStudent().add(ha.getListOfAllAssignments().get(4));
        hs.getListOfAllStudents().get(9).getListOfAssignmentsPerStudent().add(ha.getListOfAllAssignments().get(1));
        hs.getListOfAllStudents().get(9).getListOfAssignmentsPerStudent().add(ha.getListOfAllAssignments().get(3));
        hs.getListOfAllStudents().get(9).getListOfAssignmentsPerStudent().add(ha.getListOfAllAssignments().get(4));
        hs.getListOfAllStudents().get(10).getListOfAssignmentsPerStudent().add(ha.getListOfAllAssignments().get(1));
        hs.getListOfAllStudents().get(10).getListOfAssignmentsPerStudent().add(ha.getListOfAllAssignments().get(3));
        hs.getListOfAllStudents().get(11).getListOfAssignmentsPerStudent().add(ha.getListOfAllAssignments().get(0));
        hs.getListOfAllStudents().get(11).getListOfAssignmentsPerStudent().add(ha.getListOfAllAssignments().get(1));
        hs.getListOfAllStudents().get(11).getListOfAssignmentsPerStudent().add(ha.getListOfAllAssignments().get(3));
        hs.getListOfAllStudents().get(12).getListOfAssignmentsPerStudent().add(ha.getListOfAllAssignments().get(1));
        hs.getListOfAllStudents().get(12).getListOfAssignmentsPerStudent().add(ha.getListOfAllAssignments().get(4));
        hs.getListOfAllStudents().get(13).getListOfAssignmentsPerStudent().add(ha.getListOfAllAssignments().get(1));
        hs.getListOfAllStudents().get(13).getListOfAssignmentsPerStudent().add(ha.getListOfAllAssignments().get(2));
        hs.getListOfAllStudents().get(13).getListOfAssignmentsPerStudent().add(ha.getListOfAllAssignments().get(3));
        hs.getListOfAllStudents().get(14).getListOfAssignmentsPerStudent().add(ha.getListOfAllAssignments().get(2));
        hs.getListOfAllStudents().get(14).getListOfAssignmentsPerStudent().add(ha.getListOfAllAssignments().get(4));
    }

}
