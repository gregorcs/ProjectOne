package tui;
import controller.LP_Controller;
import java.util.Scanner;

public class LPMenu {
	 private LP_Controller controller;
	 private UpdateLPMenu upmenu;
	 private MainMenu menu;
	 void LPMenu() {
	        boolean running = true;
	        while (running) {
	            int choice = writeLPMenu();
	            switch (choice) {
	                case 1:
	                  controller.createLP();
	                  break;
	                case 2:
	                  controller.getLP();
	                  break;
	                case 3:
	                  upmenu.UpdateLPMenu();
	                  break;
	                case 4:
	                  controller.deleteLP();
	                  break;
	                case 0:
	                  menu.mainMenu();
	                  break;
	                default:
	                  System.out.println(" Unknown error occured, choice = "+choice);
	                  break;
	            }
	        }
	    }

	    private int writeLPMenu() {
	        Scanner keyboard = new Scanner(System.in);
	        System.out.println("****** LP Menu ******");
	        System.out.println(" (1) Create LP");
	        System.out.println(" (2) Get LP");
	        System.out.println(" (3) Update LP");
	        System.out.println(" (4) Delete LP");
	        System.out.println(" (0) Return to Main Menu");
	        System.out.print("\n Choice:");
	        
	        while (!keyboard.hasNextInt()) {
	            System.out.println("Input must be a number - please try again.");
	            keyboard.nextLine();
	        }
	        int choice = keyboard.nextInt();
	        return choice;
	    }
}
