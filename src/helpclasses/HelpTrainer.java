package helpclasses;

import basicclasses.Trainer;
import java.util.ArrayList;
import java.util.Scanner;

public class HelpTrainer {

    Scanner sc = new Scanner(System.in);

    private static ArrayList<Trainer> listOfAllTrainers = new ArrayList<>();

//***** Return the list with all trainers ***********/
    public ArrayList<Trainer> getListOfAllTrainers() {
        return listOfAllTrainers;
    }

//***** Create trainer by scanner ***************************/
    public Trainer creatScannerTrainer(Scanner sc) {
        System.out.println("Please give the first name of the trainer.");
        String firstName = sc.nextLine();
        System.out.println("Please give the last name of the trainer.");
        String lastName = sc.nextLine();
        System.out.println("Please give the subject of the trainer.");
        String subject = sc.nextLine();
        return new Trainer(firstName, lastName, subject);
    }

//***** Set the list with all trainers: create a trainer, add it to list with all trainers and return this trainer*/
    public Trainer setListOfAllTrainers() {
        Trainer element = creatScannerTrainer(sc);
        listOfAllTrainers.add(element);
        System.out.println("You just add a " + element.toString());
        System.out.println("\nFound " + listOfAllTrainers.size() + " trainer(s) now.");
        listOfAllTrainers.forEach(System.out::println);
        return element;
    }

//***** Get a trainer from parameter, check if exist in list with all trainers and if it isn't, add it ***/
    public boolean checkTrainerInList(Trainer elementTrainer) {
        boolean result = true;
        if (listOfAllTrainers.isEmpty()){
            result = true;
        } else {
            for (Trainer t : listOfAllTrainers){
                if (t.getFirstName().equalsIgnoreCase(elementTrainer.getFirstName()) 
                        && t.getLastName().equalsIgnoreCase(elementTrainer.getLastName())){
                    result = false;
                    break;
                } else {
                    result = true;
                }
            }
        }
        return result;
    }

    public void prinIfTrainerIsInList(Trainer elementTrainer){
        if (checkTrainerInList(elementTrainer) == true){
            listOfAllTrainers.add(elementTrainer);
            System.out.println("Also, this trainer added in list of all trainers because didn't exist.");
        }
    }

}
