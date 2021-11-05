package controller;
import java.util.Scanner;
import model.*;
import tui.PersonMenu;

public class LoanController {
	Scanner keyboard;
	PersonMenu personMenu;
	PersonController personController = new PersonController();
	PersonContainer personContainer = new PersonContainer();
	LP_Controller lpController = new LP_Controller();
	LP_Container lpContainer = new LP_Container();
	LoanContainer loanContainer = new LoanContainer();
	public boolean hasAccount;
	
	public LoanController() {
		personMenu = new PersonMenu();
	}
	
	public void createLoan() {
		System.out.println("***Log in***");
		keyboard = new Scanner(System.in);
		int phoneNum = getPhoneNumber();
		// searches if the person is already in the person container
		Person borrower = findAccount(phoneNum);

		if (!hasAccount) {
			printNeedAccount();
			personMenu.start();
		}
			// G: MAYBE CHANGE THIS TO NAME OR ID OR SMTH -- M: nah, the phone number functions as an ID of sorts
			// G: TO-DO: change this to search by name -- M: names could be identical, numbers are usually one of a kind
			
			lpController.printAllLP();
			int timePeriod = askRentPeriod();
			LP lp = LP_Container.getInstance().findLP();
			Loan loan = new Loan(borrower, lp, timePeriod);
			
			// LP is set to rented so it doesn't show up in searches
			lp.setRented(true);
			System.out.println("Your order is ready: ");
			printLoan(lp, borrower);
			LoanContainer.getInstance().createLoan(borrower, lp, timePeriod);
	}
	
	public void returnLP() {
		System.out.println("***Log in***");
		keyboard = new Scanner(System.in);
		int phoneNum = getPhoneNumber();
		Person borrower = findAccount(phoneNum);

		if (!hasAccount) {
			printNeedAccount();
			personMenu.start();
		}		
		
		int id = loanContainer.getID();
		Loan endLoan = loanContainer.selectLoan(id);
		LP lp = lpContainer.selectLP();
		printLoan(lp, borrower);
		lp.setRented(false);
		System.out.println("Success! You've returned your LP.");
		loanContainer.loanList.remove(endLoan);
	}
	
	public int getPhoneNumber() {
		System.out.println("Enter your phone number: ");
		int phoneNum = keyboard.nextInt();
		return phoneNum;
	}
	
	public int askRentPeriod() {
		System.out.println("Enter the rental period: ");
		int timePeriod = keyboard.nextInt();
		return timePeriod;
	}
	
	public Person findAccount(int phoneNum) {
		Person personToFind = null;
		personToFind = PersonContainer.getInstance().searchForPerson(phoneNum);
		if (personToFind == null) {
			System.out.println("Person not found.");
		} else if (personToFind.getPhone() == phoneNum) {
			hasAccount = true;
		}
		return personToFind;
	}
	
	public void printNeedAccount() {
		System.out.println("You need to create an account.");
	}
	
	public void printLoan(LP lp, Person borrower) {
		personController.readPerson(borrower);
		lpController.getLP(lp);
	}
	
	public void printAllLoans() {
		LoanContainer.getInstance().printAllLoans();
	}
}