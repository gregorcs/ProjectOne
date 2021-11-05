package tui;
import java.util.Scanner;
import controller.LP_Controller;
import controller.LoanController;

public class LoanMenu {
    LoanController loanController;
    LP_Controller lpController;
    MainMenu menu;
    
    public LoanMenu() {
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
                case 4:
                	loanController.returnLP();
                case 0:
                	menu = new MainMenu();
                	menu.start();
                	break;
                default:
                	menu.errorMess();
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
        System.out.println(" (4) Return LP");
        System.out.println(" (0) Return to Main Menu");
        System.out.print("\n Choice:");
        int choice = getIntegerFromUser(keyboard);
        return choice;
    }
    
    private int getIntegerFromUser(Scanner keyboard) {
        while (!keyboard.hasNextInt()) {
            menu.in_errorMess();
            keyboard.nextLine();
        }
        return keyboard.nextInt();
    }
}