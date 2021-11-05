package model;
import java.util.ArrayList;
import java.util.Scanner;

public class LoanContainer {
	private static LoanContainer instance;
	public ArrayList<Loan> loanList;
	Scanner keyboard;
	
	public LoanContainer () {
		loanList = new ArrayList<>();
	}

	public static LoanContainer getInstance() {
		if (instance == null) {
            instance = new LoanContainer();
		}

        return instance;
	}

	public Loan searchForLoan (int id) {
		keyboard = new Scanner(System.in);
		id = keyboard.nextInt();
		Loan loan = null;
		for (Loan tempLoan : loanList) {
			if (tempLoan.getId() == id) {
				loan = tempLoan;
			}
		}
		return loan;
	}
	
	
	/* CRUD METHODS */
	public void createLoan(Person borrower, LP lp, int rentPeriod) {
		loanList.add(new Loan(borrower, lp, rentPeriod));
	}
	
	public void readLoan(int id) {
		searchForLoan(id);		
	}
	
	public void updateLoan() {
		
	}
	
	public Loan selectLoan(int id) {
		id = LoanContainer.getInstance().getID();
		System.out.println(LoanContainer.getInstance().getID());
		System.out.println("Please copy the Loan ID of the LP you wish to return.");
		return searchForLoan(id);
	}

	public void deleteLoan(int id) {
		Loan loanToRemove = searchForLoan(id);
		loanList.remove(loanToRemove);
	}
	
	public int getID() {
		int id = loanList.size();
		return id;
	}
	
	public ArrayList<Loan> getLoanArray() {
		return loanList;
	}
	
	public void printAllLoans() {
		System.out.println("*****All Loans*****");
		System.out.println("You have currently " + loanList.size() + " active loans");
		System.out.println("*******************");
	}
}