package Containers;

import java.util.ArrayList;
import java.util.Scanner;

import controller.Person;

//Singleton
public class ContainerPerson {

	private static ContainerPerson instance;
	private ArrayList<Person> personList;
	
	private ContainerPerson () {
		personList = new ArrayList<>();
	}
	/*Returns an instance, creates one if one doesn't exist*/
	public static ContainerPerson getInstance() {
		if (instance == null) {

            instance = new ContainerPerson();
		}

        return instance;
	}
	
	/* Searches for a person base on their phone number */	
	public Person searchForPerson (int phoneNumber) {
		Person person = null;
		for (Person tempPerson : personList) {
			if (tempPerson.getPhone() == phoneNumber) {
				person = tempPerson;
			}
		}
		return person;
	}
	
	/* CRUD METHODS */
	
	//adds the person to the singleton
	public void createPerson(String name, String address, int postalCode, String city, int phone) {
		personList.add(new Person(name, address, postalCode, city, phone));
	}
	
	public void readPerson(int phoneNumber) {
		Person person = searchForPerson(phoneNumber);
		System.out.println("1. Name: " + person.getName());
		System.out.println("2. Address: " + person.getAddress());
		System.out.println("3. Postal code: " + person.getPostalCode());
		System.out.println("4. City: " + person.getCity());
		System.out.println("5. Phone number: " + person.getPhone());
		
	}
	
	public void updatePerson(int phoneNumber) {
		Person personToUpdate = searchForPerson(phoneNumber);
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter number of what you want to edit: ");
		int userChoice = keyboard.nextInt();
		readPerson(phoneNumber);
		switch (userChoice) {
		case '1':
			System.out.println("Enter your new name: ");
			personToUpdate.setName(keyboard.nextLine());
			break;
		case '2':
			System.out.println("Enter your new address: ");
			personToUpdate.setAddress(keyboard.nextLine());
			break;
		case '3':
			System.out.println("Enter your new postal code: ");
			personToUpdate.setPostalCode(keyboard.nextInt());
			break;
		case '4':
			System.out.println("Enter your new city: ");
			personToUpdate.setCity(keyboard.nextLine());
			break;
		case '5':
			System.out.println("Enter your new phone number: ");
			personToUpdate.setPhone(keyboard.nextInt());
			
		}
		
	}

	public void deletePerson(int phoneNumber) {
		Person personToRemove = searchForPerson(phoneNumber);
		personList.remove(personToRemove);
		
		
	}
}
