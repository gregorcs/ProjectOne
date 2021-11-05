package tui;
import java.util.Scanner;
import model.LP;
import model.LP_Container;

public class UpdateLPMenu {
	Scanner keyboard;
	private MainMenu menu;
	private LPMenu lpMenu;
	private LP_Container container;
	
		 public void UpdateLPMenu() {
			 writeUpdateLPMenu();
		     LP_Container.getInstance();
		     updateLP();
		 }
		 
		 public UpdateLPMenu() {
			container = new LP_Container();
			
		 }
		 
		 public void updateLP() {
				LP lpToUpdate = container.getLPToModify();
				keyboard = new Scanner(System.in);
				// container.printLP(lpToUpdate);
				String entnew = "Enter new ";
				
				System.out.println("Pick the attribute you'd like to edit: ");
				
				int userChoice = 0;
				userChoice = keyboard.nextInt();
				
				switch (userChoice) {
				case 1:
					System.out.println(entnew + "barcode: ");
					lpToUpdate.setBarcode();
					break;
				case 2:
					System.out.println(entnew + "title: ");
					lpToUpdate.setTitle();
					break;
				case 3:
					System.out.println(entnew + "artist: ");
					lpToUpdate.setArtist();
					break;
				case 4:
					System.out.println(entnew + "date of publication: ");
					lpToUpdate.setDate();
					break;
				case 0:
					lpMenu = new LPMenu();
					lpMenu.start();
					break;
		        default:
		        	menu.errorMess();
		            break;
				}
			}
		    
		 private int writeUpdateLPMenu() {
			 keyboard = new Scanner(System.in);
			 System.out.println("****** Update LP Menu ******");
		     System.out.println(" (1) Modify Barcode");
		     System.out.println(" (2) Modify Title");
		     System.out.println(" (3) Modify Artist");
		     System.out.println(" (4) Modify Publication Date");
		     System.out.println(" (0) Return to LP Menu");  
		     System.out.print("\n Choice:");
		     
		     while (!keyboard.hasNextInt()) {
		        	menu.in_errorMess();
		            keyboard.nextLine();
		     }
		        int choice = keyboard.nextInt();
		        return choice;
		 }   
}