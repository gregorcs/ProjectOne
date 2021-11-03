package tui;
import java.util.Scanner;

import model.LP_Container;

public class UpdateLPMenu {
		 private LP_Container container;
		 private LPMenu menu;
		 public void UpdateLPMenu() {
		        boolean running = true;
		        while (running) {
		            int choice = writeUpdateLPMenu();
		            switch (choice) {
		                case 1:
		                  System.out.println("Enter the new barcode: ");
		                  container.getLPToModify().setBarcode();
		                  break;
		                case 2:
		                  System.out.println("Enter the new title: ");
		                  container.getLPToModify().setTitle();
		                  break;
		                case 3:
		                  System.out.println("Enter the new artist: ");
		                  container.getLPToModify().setArtist();
		                  break;
		                case 4:
		                  System.out.println("Enter the new publication date: ");
		                  container.getLPToModify().setDate();
		                  break;
		                case 0:
		                  menu.LPMenu();
		                  break;
		                default:
		                  System.out.println(" Unknown error occured, choice = "+choice);
		                  break;
		            }
		        }
		    }

		    private int writeUpdateLPMenu() {
		        Scanner keyboard = new Scanner(System.in);
		        System.out.println("****** Update LP Menu ******");
		        System.out.println(" (1) Modify Barcode");
		        System.out.println(" (2) Modify Title");
		        System.out.println(" (3) Modify Artist");
		        System.out.println(" (4) Modify Publication Date");
		        System.out.println(" (0) Return to LP Menu");
		        System.out.print("\n Choice:");
		        
		        while (!keyboard.hasNextInt()) {
		            System.out.println("Input must be a number - please try again.");
		            keyboard.nextLine();
		        }
		        int choice = keyboard.nextInt();
		        return choice;
		    }
}