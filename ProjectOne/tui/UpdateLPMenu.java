package tui;
import java.util.Scanner;

import model.LP_Container;

public class UpdateLPMenu {
		 private LP_Container container;
		 private LPMenu menu;
		 
		 public void UpdateLPMenu() {
			 writeUpdateLPMenu();
		     LP_Container.getInstance().updateLP();
		     
		 }
		    
		 private void writeUpdateLPMenu() {
			 System.out.println("****** Update LP Menu ******");
		     System.out.println(" (1) Modify Barcode");
		     System.out.println(" (2) Modify Title");
		     System.out.println(" (3) Modify Artist");
		     System.out.println(" (4) Modify Publication Date");
		     System.out.println(" (0) Return to LP Menu");
		        
		    }
}