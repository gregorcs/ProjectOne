package model;
import java.util.ArrayList;
import java.util.Scanner;
import tui.UpdateLPMenu;
import controller.*;

/**
 * The Container class contains LP metadata.
 *
 * @author (MaxRulez)
 * @version (2/11/21, v0)
 */

public class LP_Container {
	private ArrayList <LP> database;
	private static LP_Container instance;
    Scanner keyboard;
    private UpdateLPMenu upmenu;
    private LP_Controller controller = new LP_Controller();
    LP LPToModify;
    
    private LP_Container() {
    	database = new ArrayList<>();
    }
    
    public static LP_Container getInstance() {
    	if (instance == null) {
    		instance = new LP_Container();
    	}
    	
    	return instance;
    }
    
    public void addLP(int barcode, String title, String artist, int publicationDate) {
		database.add(new LP(barcode, title, artist, publicationDate));
    }
   
    public void editLP(int barcode) {
    	LPToModify = findLP();
    	keyboard = new Scanner(System.in);
    	upmenu.UpdateLPMenu();
    }
    
    public void removeLP(int barcode) {
    	LP lp = findLP();
    	database.remove(lp);
    }
    
    public LP findLP() {
    	int barcode = controller.askBarcode();
    	LP lp = null;
    	for (LP i : database) {
    		if (i.getBarcode() == barcode) {
    			lp = i;
    		}
    	}
    	return lp;
    }
   
    public LP getLPToModify() {
    	return LPToModify;
    }
    
    public void printLP(LP lp) {
        System.out.println("Title: " + lp.getTitle());
        System.out.println("Artist: " + lp.getArtist());
        System.out.println("Barcode: " + lp.getBarcode());
        System.out.println("Publication date: " + lp.getDate());
    }
    
    public void printAllLP() {

    	for (LP item : database) {
    		printLP(item);
    	}

    }
    
    
    
    
    
    
    
}