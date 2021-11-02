package controller;

import java.util.ArrayList;
import java.util.Scanner;

import Containers.ContainerPerson;
public class PersonController {
	
	private ContainerPerson container;
	
	public PersonController() {
		
	}
	public Person selectPerson () {
		/*TO DO Add error checks*/
		Scanner keyboard = new Scanner(System.in);
		int phoneNum = 0;
		return container.searchForPerson(phoneNum);
	}
	
	/*CRUD METHODS*/
	
	public void createPerson() {
		String name;
		String address;
		int postalCode;
		String city;
		int phone;
		
		/*UI for creating a person*/
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Please enter your full name: ");
		name = keyboard.nextLine();
		System.out.println("Please enter your address: ");
		address = keyboard.nextLine();
		System.out.println("Please enter your postal code: ");
		postalCode = keyboard.nextInt();
		System.out.println("Please enter your city: ");
		city = keyboard.nextLine();
		System.out.println("Please enter your phone number: ");
		phone = keyboard.nextInt();
		
		container.createPerson(name, address, postalCode, city, phone);
		
	}
	
	public void readPerson() {
		container.readPerson(askForPhoneNumber());
		
	}
	
	public void updatePerson() {
		container.updatePerson(askForPhoneNumber());
		
	}
	
	
	
	/*TO DO make keyboard local for this class */
	public void deletePerson() {
		int phoneNumber = askForPhoneNumber();
		container.deletePerson(phoneNumber);
		
	}
	
	public int askForPhoneNumber() {
		int phoneNumber;
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Please enter your phone number to make changes: ");
		phoneNumber = keyboard.nextInt();
		
		return phoneNumber;
	}
	
	
	
	
}
