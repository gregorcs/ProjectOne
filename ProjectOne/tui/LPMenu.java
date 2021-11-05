package tui;
import controller.LP_Controller;
import java.util.Scanner;

public class LPMenu {
	 private LP_Controller controller;
	 private UpdateLPMenu upmenu;
	 private MainMenu menu;
	 
	 public LPMenu() {
		 controller = new LP_Controller();
     }
	 
	 public void start() {
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
	                  upmenu = new UpdateLPMenu();
	                  upmenu.UpdateLPMenu();
	                  break;
	                case 4:
	                	// TO-DO: deleteLP asks for phone number twice
	                  controller.deleteLP();
	                  break;
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

	    public int writeLPMenu() {
	        Scanner keyboard = new Scanner(System.in);
	        System.out.println("****** LP Menu ******");
	        System.out.println(" (1) Create LP");
	        System.out.println(" (2) Get LP");
	        System.out.println(" (3) Update LP");
	        System.out.println(" (4) Delete LP");
	        System.out.println(" (0) Return to Main Menu");
	        System.out.print("\n Choice:");
	        
	        while (!keyboard.hasNextInt()) {
	        	menu.in_errorMess();
	            keyboard.nextLine();
	        }
	        int choice = keyboard.nextInt();
	        return choice;
	    }   
}