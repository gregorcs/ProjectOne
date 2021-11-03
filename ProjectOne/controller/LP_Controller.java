package controller;
import java.util.Scanner;
import Containers.LP_Container;

public class LP_Controller {
	private LP_Container container;
	Scanner keyboard;
	
    public void createLP() {
    	String title, artist;
    	int barcode, publicationDate;
    	keyboard = new Scanner(System.in);
    	
		System.out.println("Please enter the title of the LP: ");
		title = keyboard.nextLine();
		System.out.println("Please enter the name of the composing artist: ");
		artist = keyboard.nextLine();
		System.out.println("Please enter the barcode (found on back of the cover): ");
		barcode = keyboard.nextInt();
		System.out.println("Please enter the year the LP was published in: ");
		publicationDate = keyboard.nextInt();
		
		LP_Container.getInstance().addLP(barcode, title, artist, publicationDate);
    }
    
    public void getLP() {
    	LP lp = LP_Container.getInstance().findLP();
    	System.out.println("Barcode: " + lp.getBarcode());
		System.out.println("Title: " + lp.getTitle());
		System.out.println("Artist: " + lp.getArtist());
		System.out.println("Publication Date: " + lp.getDate());
    }
    
    public void updateLP() {
    	LP_Container.getInstance().editLP(askBarcode());
    }
    
    public void deleteLP() {
    	LP_Container.getInstance().removeLP(askBarcode());
    }

    public int askBarcode() {
    	int barcode;
    	Scanner keyboard = new Scanner(System.in);
    	System.out.println("Please enter the barcode of the LP you'd like to modify: ");
    	barcode = keyboard.nextInt();
    	
		return barcode;
    }

}