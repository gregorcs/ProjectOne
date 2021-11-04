package model;

import java.util.ArrayList;
import java.util.Scanner;

import controller.LoanController;

public class LoanContainer {

	private static LoanContainer instance;
	private ArrayList<Loan> loanList;
	private LoanController loanController;
	
	private LoanContainer () {
		loanList = new ArrayList<>();
		loanController = new LoanController();
	}
	/*Returns an instance, creates one if one doesn't exist*/
	public static LoanContainer getInstance() {
		if (instance == null) {
            instance = new LoanContainer();
		}

        return instance;
	}
	
	/* Searches for a person base on their phone number */	
	public Loan searchForLoan (int id) {
		Loan loan = null;
		for (Loan tempLoan : loanList) {
			if (tempLoan.getId() == id) {
				loan = tempLoan;
			}
		}
		return loan;
	}
	
	
	/* CRUD METHODS */
	
	//adds the person to the singleton
	public void createLoan(Person borrower, LP lp, int rentPeriod) {
		loanList.add(new Loan(borrower, lp, rentPeriod));
	}
	
	public void readLoan(int id) {
		Loan loan = searchForLoan(id);

		
	}
	
	public void updateLoan() {
		
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
		System.out.println("You have currently: " + loanList.size() + " active loans");
		System.out.println("*****End of Loans*****");
	}
	
}
