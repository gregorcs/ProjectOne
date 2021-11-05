package tui;
import java.util.Scanner;
import controller.PersonController;
import model.Person;
import model.PersonContainer;

public class PersonMenu {
	private PersonContainer container;
	private PersonController controller;
	private MainMenu menu;
	
	public PersonMenu() {
		container = new PersonContainer();
		controller = new PersonController();
	}
	
	public void start() {
		boolean running = true;
		while(running) {
			int userChoice = writePersonMenu();
			switch(userChoice) {
			case 1:
				controller.createPerson();
				break;
			case 2:
				controller.readPerson();
				break;
			case 3:
				controller.updatePerson();
				break;
			case 4:
				controller.deletePerson();
				break;
			case 0:
				menu = new MainMenu();
				menu.start();
				break;
            default:
            	menu = new MainMenu();
                menu.errorMess();
                break;
			}
			
		}
	}
		
		public void updatePerson(int phoneNumber) {
			Person personToUpdate = container.searchForPerson(phoneNumber);
			Scanner keyboard = new Scanner(System.in);
			System.out.println("Pick the attribute you'd like to edit: ");
			container.readPerson(phoneNumber);
			int userChoice = 0;
			userChoice = keyboard.nextInt();
			keyboard.nextLine();
			switch (userChoice) {
			case 1:
				System.out.println("Enter your new name: ");
				personToUpdate.setName(keyboard.nextLine());
				break;
			case 2:
				System.out.println("Enter your new address: ");
				personToUpdate.setAddress(keyboard.nextLine());
				break;
			case 3:
				System.out.println("Enter your new postal code: ");
				personToUpdate.setPostalCode(keyboard.nextInt());
				break;
			case 4:
				System.out.println("Enter your new city: ");
				personToUpdate.setCity(keyboard.nextLine());
				break;
			case 5:
				System.out.println("Enter your new phone number: ");
				personToUpdate.setPhone(keyboard.nextInt());
				break;
	        default:
	            menu.errorMess();
	            break;
				
			}
	}
	
	private int writePersonMenu() {
		Scanner keyboard = new Scanner(System.in);
        System.out.println("****** Person Menu ******");
        System.out.println(" (1) Create Person");
        System.out.println(" (2) Get Person");
        System.out.println(" (3) Update Person");
        System.out.println(" (4) Delete Person");
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
