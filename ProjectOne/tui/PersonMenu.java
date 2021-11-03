package tui;

import java.util.Scanner;

import controller.PersonController;

public class PersonMenu {

	private PersonController personController;
	
	public PersonMenu() {
		personController = new PersonController();
	}
	public void personMenu() {
		boolean running = true;
		while(running) {
			int userChoice = writePersonMenu();
			switch(userChoice) {
			case 1:
				personController.createPerson();
				break;
			case 2:
				personController.readPerson();
				break;
			case 3:
				personController.updatePerson();
				break;
			case 4:
				personController.deletePerson();
				break;
			case 0:
				running = false;
            default:
                System.out.println(" Unknown error occured, choice = "+ userChoice);
                break;
			}
			
		}
		

	}
	
	private int writePersonMenu() {
		Scanner keyboard = new Scanner(System.in);
        System.out.println("****** Person Menu ******");
        System.out.println(" (1) Create Person");
        System.out.println(" (2) Get Person");
        System.out.println(" (3) Update Person");
        System.out.println(" (4) Delete Person");
        System.out.println(" (0) Go back");
        System.out.print("\n Choice:");
        
        while (!keyboard.hasNextInt()) {
            System.out.println("Input must be a number - please try again.");
            keyboard.nextLine();
        }
        int choice = keyboard.nextInt();
        return choice;
	}
}
