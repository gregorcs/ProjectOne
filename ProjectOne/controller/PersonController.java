package controller;

import java.util.ArrayList;
import java.util.Scanner;

import model.PersonContainer;
import model.Person;
public class PersonController {
	
	
	public PersonController() {
		
	}
	public Person selectPerson () {
		/*TO DO Add error checks*/
		Scanner keyboard = new Scanner(System.in);
		int phoneNum = 0;
		return PersonContainer.getInstance().searchForPerson(phoneNum);
	}
	
	/*CRUD METHODS*/
	
	public void createPerson() {
		String name;
		String address;
		int postalCode;
		String city;
		int phone;
		/*TO DO make this method in the controller, then return an object here*/
		/*UI for creating a person*/
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Please enter your full name: ");
		name = keyboard.nextLine();
		System.out.println("Please enter your address: ");
		address = keyboard.nextLine();
		System.out.println("Please enter your postal code: ");
		postalCode = keyboard.nextInt();
		keyboard.nextLine();
		System.out.println("Please enter your city: ");
		city = keyboard.nextLine();
		System.out.println("Please enter your phone number: ");
		phone = keyboard.nextInt();
		PersonContainer.getInstance().createPerson(name, address, postalCode, city, phone);
		
	}
	
	public void readPerson() {
		PersonContainer.getInstance().readPerson(askForPhoneNumber());
		
	}
	
	public void updatePerson() {
		PersonContainer.getInstance().updatePerson(askForPhoneNumber());
		
	}
	
	
	
	/*TO DO make keyboard local for this class */
	public void deletePerson() {
		int phoneNumber = askForPhoneNumber();
		PersonContainer.getInstance().deletePerson(phoneNumber);
		
	}
	
	public int askForPhoneNumber() {
		int phoneNumber;
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Please enter your phone number to make changes: ");
		phoneNumber = keyboard.nextInt();
		
		return phoneNumber;
	}
	
	
	
	
}
