package controller;

/**
 * Creates the LP objects with suitable attributes (barcode, title, artist, publication date).
 *
 * @author (MaxRulez)
 * @version (2/11/21, v0)
 */

public class LP {
    private int barcode, date;
    private String title, artist;
    
    /**
     * Constructor for objects of class LP
     */
    public LP(int barcode, String title, String artist, int date) {
        this.barcode = barcode;
        this.title = title;
        this.artist = artist;
        this.date = date;
    }
    
    public void print() {
    	System.out.println(title + " " + artist + " " + " " + date + " " + barcode);
    }
   
}
