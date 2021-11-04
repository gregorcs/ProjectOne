package tui;
import java.util.Scanner;

import controller.LP_Controller;
import controller.LoanController;
import model.LoanContainer;
/**
 * Write a description of class LoanMenu here.
 *
 * @author Mogens Holm Iversen
 * @version 0.1.0 Initial draft version 
 */
public class LoanMenu {
    // instance variables
    LoanController loanController;
    LP_Controller lpController;
    
    /*Constructor for objects of class LoanMenu*/
    public LoanMenu() {
        // Initialize instance variables
    	loanController = new LoanController();
    	lpController = new LP_Controller();
              
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
                	loanController.createLoan();
                	break;
                case 2:
                	lpController.printAllLP();
                	break;
                case 3:
                	loanController.printAllLoans();
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
        System.out.println(" (2) Print available LPs");
        System.out.println(" (3) Print active loans");
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