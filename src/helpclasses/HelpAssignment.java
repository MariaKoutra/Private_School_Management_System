package helpclasses;

import administrator.CheckClass;
import basicclasses.Assignment;
import basicclasses.Course;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class HelpAssignment {

    Scanner sc = new Scanner(System.in);

    CheckClass cc = new CheckClass();

    private static ArrayList<Assignment> listOfAllAssignments = new ArrayList<>();

    /**
     * ************* Create assignment by scanner **************
     */
    public Assignment creatScannerAssignment(Scanner sc) {
        System.out.println("Please give the title of the assignment:");
        String title = sc.nextLine();
        System.out.println("Please give the description of the assignment:");
        String description = sc.nextLine();
        System.out.println("Please give the date of submission of the assignment in format \"yyyy-mm-dd\":");
        LocalDate subDateTime = cc.checkDate();
        System.out.println("Please give the oral mark of the assignment:");
        int oralMark = cc.checkInt();
        System.out.println("Please give the total mark of the assignment:");
        int totalMark = cc.checkInt();
        return new Assignment(title, description, subDateTime, oralMark, totalMark);
    }

    /**
     * ***** return the list with all assignments ******
     */
    public ArrayList<Assignment> getListOfAllAssignments() {
        return listOfAllAssignments;
    }

    /**
     * set the list with all assignments: create a assignment, add it to list
     * with all assignments and return this assignment *
     */
    public Assignment setListOfAllAssignment() {
        Assignment element = creatScannerAssignment(sc);
        listOfAllAssignments.add(element);
        System.out.println("You just add an " + element.toString());
        System.out.println("\nFound " + getListOfAllAssignments().size() + " assignment(s) now.");
        listOfAllAssignments.forEach(System.out::println);
        return element;
    }

    public boolean checkAssignmentInList(Assignment elementAssignment) {
        boolean result = true;
        if (listOfAllAssignments.isEmpty()) {
            result = true;
        } else {
            for (Assignment a : listOfAllAssignments) {
                if (a.getTitle().equalsIgnoreCase(elementAssignment.getTitle())
                        && a.getDescription().equalsIgnoreCase(elementAssignment.getDescription())) {
                    result = false;
                    break;
                } else {
                    result = true;
                }
            }
        }
        return result;
    }

    public void printIfAssignmentIsInList(Assignment elementAssignment) {
        if (checkAssignmentInList(elementAssignment) == true) {
            listOfAllAssignments.add(elementAssignment);
            System.out.println("Also, this assignment added in list of all assignments because didn't exist.");
        }
    }

    public boolean checkListOfAssignmentsPerCourse(Course c, Assignment as) {
        boolean result = true;
        if (c.getListOfAssignmentsPerCourse().isEmpty()) {
            result = true;
        } else {
            for (Assignment a : c.getListOfAssignmentsPerCourse()) {
                if (a.getTitle().equalsIgnoreCase(as.getTitle()) && a.getDescription().equalsIgnoreCase(as.getDescription())) {
                    result = false;
                    break;
                } else {
                    result = true;
                }
            }
        }
        return result;
    }

    public void setMarkInAssignment() {
        boolean exist = false;
        System.out.println("Please give the title of this assignment:");
        String title = sc.nextLine();
        System.out.println("Please give the description of this assignment:");
        String description = sc.nextLine();
        for (Assignment a : listOfAllAssignments) {
            if (a.getTitle().equalsIgnoreCase(title) && a.getDescription().equalsIgnoreCase(description)) {
                exist = true;
                System.out.println("Please give the oral mark of this assignment (0-20/20):");
                int oral = cc.checkOralMark();
                a.setOralMark(oral);
                System.out.println("Please give the total mark of this assignment (0-80/80):");
                int total = cc.checkTotalMark();
                a.setTotalMark(total);
                break;
            }
        }
        if (!exist) {
            System.out.println("There is no assignment with these details.\n"
                    + "If you want to set the marks of another assignment, please press \"add\" at the assignments' details.");
        }
    }
}
