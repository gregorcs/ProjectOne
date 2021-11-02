package Containers;

import java.util.ArrayList;

import controller.Person;

public class ContainerPerson {

	private static ArrayList<Person> instance;
	
	private ContainerPerson () {
		
	}
	public ArrayList<Person> getInstance() {
		if (instance == null)
            instance = new ArrayList<Person>();
 
        return instance;
	}
	private void setInstance(ArrayList<Person> instance) {
		this.instance = instance;
	}
}
