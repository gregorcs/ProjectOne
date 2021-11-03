package controller;

import java.util.ArrayList;
import java.util.Scanner;

import Containers.ContainerPerson;
public class PersonController {
	
	
	public PersonController() {
		
	}
	public Person selectPerson () {
		/*TO DO Add error checks*/
		Scanner keyboard = new Scanner(System.in);
		int phoneNum = 0;
		return ContainerPerson.getInstance().searchForPerson(phoneNum);
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
		ContainerPerson.getInstance().createPerson(name, address, postalCode, city, phone);
		
	}
	
	public void readPerson() {
		ContainerPerson.getInstance().readPerson(askForPhoneNumber());
		
	}
	
	public void updatePerson() {
		ContainerPerson.getInstance().updatePerson(askForPhoneNumber());
		
	}
	
	
	
	/*TO DO make keyboard local for this class */
	public void deletePerson() {
		int phoneNumber = askForPhoneNumber();
		ContainerPerson.getInstance().deletePerson(phoneNumber);
		
	}
	
	public int askForPhoneNumber() {
		int phoneNumber;
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Please enter your phone number to make changes: ");
		phoneNumber = keyboard.nextInt();
		
		return phoneNumber;
	}
	
	
	
	
}
