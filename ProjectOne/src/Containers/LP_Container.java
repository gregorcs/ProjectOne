package Containers;
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
	private ArrayList <LP> database = new ArrayList <> ();
    Scanner keyboard;
    private UpdateLPMenu upmenu;
    private LP_Controller controller;
    LP LPToModify;
    
    public LP_Container() {
    	
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
}