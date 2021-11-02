package controller;
import java.util.ArrayList;

public class LP_Controller {
	LP lp;
	ArrayList <LP> LPList = new ArrayList<>();
	
    public void createLP(int barcode, String title, String artist, int date) {
    	lp = new LP(barcode, title, artist, date);
    	LPList.add(lp);
    }
    
    public LP getLP() {
    	return lp;
    }
    
    public void printAll() {
 	   for (LP list : LPList) {
 		list.print();
 	   }
    }
}   
