package tui;
import java.util.Scanner;

public class MainMenu {
    private LoanMenu loanMenu;
    private PersonMenu personMenu;
    private LPMenu lpMenu;
    
    public MainMenu() {
    }
    
    public void start() {
        mainMenu();
    }
    
    public void mainMenu() {
        boolean running = true;
        while (running) {
            int choice = writeMainMenu();
            switch (choice) {
                case 1:
                  personMenu = new PersonMenu();
                  personMenu.start();
                  break;
                case 2:
                  lpMenu = new LPMenu(); 	
                  lpMenu.start();
                  break;
                case 3:
                  loanMenu = new LoanMenu();
                  loanMenu.start();
                  break;
                case 0:
                  System.out.println("Thank you and goodbye.");
                  running = false;
                  break;
                default:
                	errorMess();
                  break;
            }
        }
    }

   public int writeMainMenu() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("****** Main menu ******");
        System.out.println(" (1) Borrower menu");
        System.out.println(" (2) LP menu");
        System.out.println(" (3) Loan menu");
        System.out.println(" (0) Quit the program");
        System.out.print("\n Choice:");
        
        while (!keyboard.hasNextInt()) {
        	in_errorMess();
            keyboard.nextLine();
        }
        int choice = keyboard.nextInt();
        return choice;
    }
   
    public void errorMess() {
    	System.out.println("Unknown error occurred.");
    }
    
    public void in_errorMess() {
   	 System.out.println("Input must be a number - please try again.");
    }
}
