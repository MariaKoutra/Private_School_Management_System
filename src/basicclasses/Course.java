package basicclasses;

import helpclasses.HelpAssignment;
import helpclasses.HelpCourse;
import helpclasses.HelpStudent;
import helpclasses.HelpTrainer;
import java.time.LocalDate;
import java.util.ArrayList;

public class Course {

    HelpTrainer ht = new HelpTrainer();
    HelpCourse hc = new HelpCourse();
    HelpStudent hs = new HelpStudent();
    HelpAssignment ha = new HelpAssignment();

    private String title;
    private String stream;
    private String type;
    private LocalDate startDate;
    private LocalDate endDate;
    private ArrayList<Trainer> listOfTrainersPerCourse;
    private ArrayList<Student> listOfStudentsPerCourse;
    private ArrayList<Assignment> listOfAssignmentsPerCourse;

    
//***** Each course have these parameters *****//
    public Course(String title, String stream, String type, LocalDate startDate, LocalDate endDate) {
        this.title = title;
        this.stream = stream;
        this.type = type;
        this.startDate = startDate;
        this.endDate = endDate;
        listOfTrainersPerCourse = new ArrayList<>();
        listOfStudentsPerCourse = new ArrayList<>();
        listOfAssignmentsPerCourse = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Course:{" + "title=" + title + ", stream=" + stream + ", type=" + type + ", start date=" + startDate + ", end date=" + endDate + '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStream() {
        return stream;
    }

    public void setStream(String stream) {
        this.stream = stream;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

//***** return the list with all trainers for each course *****//
    public ArrayList<Trainer> getListOfTrainersPerCourse() {
        return listOfTrainersPerCourse;
    }

//***** return the list with all students for each course *****//
    public ArrayList<Student> getListOfStudentsPerCourse() {
        return listOfStudentsPerCourse;
    }

//***** return the list with all assignments for each course *****//
    public ArrayList<Assignment> getListOfAssignmentsPerCourse() {
        return listOfAssignmentsPerCourse;
    }

//***** Set the list with all assignments for each course *****//
    public void setListOfAssignmentsPerCourse() {
        for (Course c : hc.getListOfAllCourses()) {
            for (Student s : c.getListOfStudentsPerCourse()) {
                for (Assignment as : s.getListOfAssignmentsPerStudent()) {
                    if (ha.checkListOfAssignmentsPerCourse(c, as) == true) {
                        c.listOfAssignmentsPerCourse.add(as);
                    }
                }
            }
        }
    }

//***** Get a student and a course from parameter and put this student to this course *****//
    public void setListOfStudentsPerCourse(Course elementCourse, Student elementStudent) {
        hc.checkCourseInList(elementCourse);
        hc.printIfCourseIsInList(elementCourse);
        hs.checkStudentInList(elementStudent);
        hs.printIfStudentIsInList(elementStudent);
        elementCourse.getListOfStudentsPerCourse().add(elementStudent);
        System.out.println("You just add a " + elementStudent.toString() + " in " + elementCourse.toString());
    }

//***** Get a course and a trainer from parameter and put this trainer to this course *****//
    public void setListOfTrainersPerCourse(Course elementCourse, Trainer elementTrainer) {
        hc.checkCourseInList(elementCourse);
        hc.printIfCourseIsInList(elementCourse);
        ht.checkTrainerInList(elementTrainer);
        ht.prinIfTrainerIsInList(elementTrainer);
        elementCourse.getListOfTrainersPerCourse().add(elementTrainer);
        System.out.println("You just add a " + elementTrainer.toString() + " in " + elementCourse.toString());
    }

}
