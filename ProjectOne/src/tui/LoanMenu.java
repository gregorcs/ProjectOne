package tui;
import java.util.Scanner;
/**
 * Write a description of class LoanMenu here.
 *
 * @author Mogens Holm Iversen
 * @version 0.1.0 Initial draft version 
 */
public class LoanMenu {
    // instance variables
    
    /**
     * Constructor for objects of class LoanMenu
     */
    public LoanMenu() {
        // initialise instance variables
              
    }

    public void start() {
        loanMenu();
    }

    private void loanMenu() {
        boolean running = true;
        while (running) {
            int choice = writeLoanMenu();
            switch (choice) {
                case 1:
                  System.out.println(" Not implemented yet");
                  break;
                case 0:
                  running = false;
                  break;
                default:
                  System.out.println(" Unknown error occured, choice = " + choice);
                  break;
            }
        }
    }
    
    private int writeLoanMenu() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("****** Loan menu ******");
        System.out.println(" (1) Create loan");
        System.out.println(" (0) Back");
        System.out.print("\n Choice:");
        int choice = getIntegerFromUser(keyboard);
        return choice;
    }
    
    private int getIntegerFromUser(Scanner keyboard) {
        while (!keyboard.hasNextInt()) {
            System.out.println("Input must be a number - please try again.");
            keyboard.nextLine();
        }
        return keyboard.nextInt();
    }
}