package model;
import java.util.Scanner;

/**
 * Creates the LP objects with suitable attributes (barcode, title, artist, publication date).
 *
 * @author (MaxRulez)
 * @version (2/11/21, v0)
 */

public class LP {
    private int barcode, publicationDate;
    private String title, artist;
    Scanner keyboard;
    
    /**
     * Constructor for objects of class LP
     */
    
    /*TO DO add state variable*/
    public LP(int barcode, String title, String artist, int publicationDate) {
        this.barcode = barcode;
        this.title = title;
        this.artist = artist;
        this.publicationDate = publicationDate;
    }

	public int getBarcode() {
		return barcode;
	}
	
	public void setBarcode() {
		barcode = keyboard.nextInt();
	}
	
	public String getTitle() {
		return title;
	}
	
    public void setTitle() {
    	title = keyboard.nextLine();
	}
	
	public String getArtist() {
		return artist;
	}
	
    public void setArtist() {
    	artist = keyboard.nextLine();
	}
	
	public int getDate() {
		return publicationDate;
	}
	
    public void setDate() {
    	publicationDate = keyboard.nextInt();
	}
   
}
