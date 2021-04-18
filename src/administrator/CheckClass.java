package administrator;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class CheckClass {

    Scanner sc = new Scanner(System.in);
    
//***** Check an Integer *****//
    public int checkInt() {
        int result = 0;
        while (true) {
            String a = sc.nextLine();
            try {
                result = Integer.parseInt(a);
                if (result < 0) {
                    System.out.println("This is a negative number. Please enter a valid number.");
                } else {
                    break;
                }
            } catch (NumberFormatException ex1) {
                System.out.println("Please enter a valid number.");
            }
        }
        return result;
    }
    
//***** Check the oral mark *****//
    public int checkOralMark() {
        int result = 0;
        while (true) {
            String a = sc.nextLine();
            try {
                result = Integer.parseInt(a);
                if (result < 0) {
                    System.out.println("This is a negative number. Please enter a valid number.");
                } else if (result > 20){
                    System.out.println("This number is bigger than 20. Please enter a valid number.");
                } else {
                    break;
                }
            } catch (NumberFormatException ex1) {
                System.out.println("Please enter a valid number.");
            }
        }
        return result;
    }
    
//***** Check the total mark *****//
    public int checkTotalMark() {
        int result = 0;
        while (true) {
            String a = sc.nextLine();
            try {
                result = Integer.parseInt(a);
                if (result < 0) {
                    System.out.println("This is a negative number. Please enter a valid number.");
                } else if (result > 80){
                    System.out.println("This number is bigger than 80. Please enter a valid number.");
                } else {
                    break;
                }
            } catch (NumberFormatException ex1) {
                System.out.println("Please enter a valid number.");
            }
        }
        return result;
    }

    
//***** Check a date *****//
    public LocalDate checkDate() {
        LocalDate result = null;
        while (true) {
            String d = sc.nextLine();
            try {
                result = LocalDate.parse(d, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                if (result.getDayOfMonth() > 31 || result.getMonthValue() > 12) {
                    System.out.println("Please enter a valid date in format: \"yyyy-mm-dd\".");
                } else {
                    break;
                }
            } catch (DateTimeParseException ex2) {
                System.out.println("Please enter a valid date in format: \"yyyy-mm-dd\".");
            }
        }
        return result;
    }

//***** Check a date in which day of week belong. Each day of week make it Monday*****//
//***** Return an array : array[0] = Monday , array[1] = Friday *****//
    public LocalDate[] checkDayOfWeek() {
        System.out.println("Please enter a date in format: \"yyyy-mm-dd\".");
        LocalDate ld = checkDate();
        LocalDate ldStart = LocalDate.parse("2020-01-01", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        int ldDay = ld.getDayOfWeek().getValue();
        switch (ldDay) {
            case 1:
                ldStart = ld;
                break;
            case 2:
                ldStart = ld.minusDays(1);
                break;
            case 3:
                ldStart = ld.minusDays(2);
                break;
            case 4:
                ldStart = ld.minusDays(3);
                break;
            case 5:
                ldStart = ld.minusDays(4);
                break;
            case 6:
                ldStart = ld.minusDays(5);
                break;
            case 7:
                ldStart = ld.minusDays(6);
                break;
            default:
                break;
        }
        LocalDate[] week = new LocalDate[2];
        week[0] = ldStart;
        week[1] = ldStart.plusDays(4);
        return week;
    }
    
}
