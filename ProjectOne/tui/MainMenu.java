package tui;
import java.util.Scanner;

/**
 * Write a description of class MainMenu here.
 *
 * @author Mogens Holm Iversen
 * @version 0.1.0 Initial draft version 
 */
public class MainMenu {
    // instance variables 
    private LoanMenu loanMenu;
    /**
     * Constructor for objects of class MainMenu
     */
    public MainMenu() {
        // Initialize instance variables
        loanMenu = new LoanMenu();
        
       
    }
    
    public void start() {
        mainMenu();
    }
    
    void mainMenu() {
        boolean running = true;
        while (running) {
            int choice = writeMainMenu();
            switch (choice) {
                case 1:
                  System.out.println(" Not implemented yet");
                  break;
                case 2:
                  System.out.println(" Not implemented yet");
                  break;
                case 3:
                  loanMenu.start();
                  break;
                case 9:
                  System.out.println(" Not implemented yet");
                  break;
                case 0:
                  System.out.println(" Thank you and goodbye.");
                  running = false;
                  break;
                default:
                  System.out.println(" Unknown error occured, choice = "+choice);
                  break;
            }
        }
    }

    private int writeMainMenu() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("****** Main menu ******");
        System.out.println(" (1) Borrower menu");
        System.out.println(" (2) LP menu");
        System.out.println(" (3) Loan menu");
        System.out.println(" (9) Generate testdata");// will generate testdata, delete in final version
        System.out.println(" (0) Quit the program");
        System.out.print("\n Choice:");
        
        while (!keyboard.hasNextInt()) {
            System.out.println("Input must be a number - please try again");
            keyboard.nextLine();
        }
        int choice = keyboard.nextInt();
        return choice;
    }
   
}
