package model;
import java.util.ArrayList;

//Singleton
public class PersonContainer {
	private static PersonContainer instance;
	private ArrayList<Person> personList;
	
	public PersonContainer() {
		personList = new ArrayList<>();
	}
	
	// returns an instance, creates one if one doesn't exist
	public static PersonContainer getInstance() {
		if (instance == null) {
            instance = new PersonContainer();
		}

        return instance;
	}
	
	// searches for a person based on their phone number
	public Person searchForPerson (int phoneNumber) {
		Person person = null;
		for (Person tempPerson : personList) {
			if (tempPerson.getPhone() == phoneNumber) {
				person = tempPerson;
			} else {
				System.out.println("Unable to find a person with this phone number.");
			}
		}
		return person;
	}
	
	/* CRUD METHODS */
	
	// adds the person to the singleton
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
	
	public void readPerson(Person person) {
		System.out.println("1. Name: " + person.getName());
		System.out.println("2. Address: " + person.getAddress());
		System.out.println("3. Postal code: " + person.getPostalCode());
		System.out.println("4. City: " + person.getCity());
		System.out.println("5. Phone number: " + person.getPhone());
	}

	public void deletePerson(int phoneNumber) {
		Person personToRemove = searchForPerson(phoneNumber);
		personList.remove(personToRemove);	
	}
}