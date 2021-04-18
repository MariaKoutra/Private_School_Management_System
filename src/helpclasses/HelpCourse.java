package helpclasses;

import administrator.CheckClass;
import basicclasses.Course;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class HelpCourse {

    Scanner sc = new Scanner(System.in);
    CheckClass cc = new CheckClass();

    private static ArrayList<Course> listOfAllCourses = new ArrayList<>();

//***** Create course by scanner ***************************/
    public Course creatScannerCourse(Scanner sc) {
        System.out.println("Please give the title of the Course:");
        String title = sc.nextLine();
        System.out.println("Please give the stream of the Course:");
        String stream = sc.nextLine();
        System.out.println("Please give the type of the Course:");
        String type = sc.nextLine();
        System.out.println("Please give the start date of the Course in format \"yyyy-mm-dd\":");
        LocalDate startDate = cc.checkDate();
        System.out.println("Please give the end date of the Course in format \"yyyy-mm-dd\":");
        LocalDate endDate = cc.checkDate();
        return new Course(title, stream, type, startDate, endDate);
    }

//***** Return the list with all courses ***************/
    public ArrayList<Course> getListOfAllCourses() {
        return listOfAllCourses;
    }

//** Set the list with all courses: create a course from scanner, add it to list with all courses and return this course **/
    public Course setListOfAllCourses() {
        Course element = creatScannerCourse(sc);
        getListOfAllCourses().add(element);
        System.out.println("You just add a " + element.toString());
        System.out.println("\nFound " + listOfAllCourses.size() + " course(s) now.");
        listOfAllCourses.forEach(System.out::println);
        return element;
    }

//***** Get a course from parameter, check if exist in list with all courses and if it isn't, add it *******/
    public boolean checkCourseInList(Course elementCourse) {
        boolean result = true;
        if (listOfAllCourses.isEmpty()) {
            result = true;
        } else {
            for (Course c : getListOfAllCourses()) {
                if (c.getTitle().equalsIgnoreCase(elementCourse.getTitle())
                        && c.getStream().equalsIgnoreCase(elementCourse.getStream())
                        && c.getType().equalsIgnoreCase(elementCourse.getType())) {
                    result = false;
                    break;
                } else {
                    result = true;
                }
            }
        }
        return result;
    }

    public void printIfCourseIsInList(Course elementCourse) {
        if (checkCourseInList(elementCourse) == true) {
            listOfAllCourses.add(elementCourse);
            System.out.println("Also, this course added it in list of all courses because didin't exist.");
        }
    }
}
