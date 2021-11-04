package controller;

import java.util.Scanner;
import model.LP;
import model.LP_Container;
import model.Loan;
import model.Person;
import model.PersonContainer;
import tui.PersonMenu;

public class LoanController {

	Scanner keyboard = new Scanner(System.in);
	PersonMenu personMenu = new PersonMenu();
	PersonController personController = new PersonController();
	LP_Controller lpController = new LP_Controller();
	boolean hasAccount = false;
	
	public LoanController() {
		
	}
	
	public void createLoan() {
		/*checks if they already have an account */
		if (!hasAccount) {
			printNeedAccount();
			int phoneNum;
			personMenu.personMenu();
			System.out.println("***Log in***");
			/* MAYBE CHANGE THIS TO NAME OR ID OR STH */
			phoneNum = getPhoneNumber();
			/*searches if the person is already in the person container */
			findAccount(phoneNum);
		}
		
		else {
			int phoneNum = getPhoneNumber();
			Person borrower = findAccount(phoneNum);
			/* TO DO change this to search by name */
			lpController.printAllLP();
			int timePeriod = askRentPeriod();
			LP lp = LP_Container.getInstance().findLP();
			Loan loan = new Loan(borrower, lp, timePeriod);
			/*lp is set to rented so it doesn't show up in searches */
			//LP set rented here
			lp.setRented(true);
			System.out.println("Your order is ready: ");
			printLoan(lp, borrower);
		}
		
	}
	
	public int getPhoneNumber() {
		System.out.println("Enter your phone number: ");
		int phoneNum = keyboard.nextInt();
		return phoneNum;
	}
	
	public int askRentPeriod() {
		System.out.println("Type the rent period: ");
		int timePeriod = keyboard.nextInt();
		return timePeriod;
	}
	
	public Person findAccount(int phoneNum) {
		Person personToFind = PersonContainer.getInstance().searchForPerson(phoneNum);
		if (personToFind.getPhone() == phoneNum) {
			hasAccount = true;
		}
		else {
			System.out.println("Person not found");
			return null;
		}
		return personToFind;
	}
	public void printNeedAccount() {
		System.out.println("You need to create and account");
	}
	public void printLoan(LP lp, Person borrower) {
		personController.readPerson(borrower);
		lpController.getLP(lp);
	}
	public void printAllLoans() {
		
	}
}
