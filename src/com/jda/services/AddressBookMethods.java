package com.jda.services;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import com.jda.model.*;
import com.jda.utility.Utility2;

public class AddressBookMethods {
	
	
	
	public static List<Person> list = new ArrayList<Person>();
	
	Utility2 utility = new Utility2();
	
	public List<Person> adding() {
		list.add(add());
		for (Person p : list) {
			System.out.println(p.toString());
		}
		return list;
	}
	
	
	
	public void remove()  {
		System.out.println("Enter first name whose data is to be removed");
		String firstName = utility.inputString();
		int count = 0;
		List<Person> toRemove = new ArrayList<>();
		for (Person  p: list) {
			if (firstName.equals(p.getFirstName())) {
				System.out.println("Data Removed");
				toRemove.add(p);
				count++;
			}
		}
		list.removeAll(toRemove);
		if (count == 0)
			System.out.println("no such data found");
		
	
	}
	
	public void sortByName() {
	
		Collections.sort(list,new SortByName());
		for (Person person : list) {
			System.out.println(person.toString());
		}
	}
	
	public void sortByZip()
	{
		Collections.sort(list,new SortByZip());
		for (Person person : list) {
			System.out.println(person.toString());
		}
	}
	
	
	

public	void editAddress() {
	//Person P = new Person();
	String s = utility.inputString();
	for (Person P : list) {
		if (s.equals(P.getFirstName())) {
			System.out.println("\n\t\t\tEnter the state");
			P.address.setState(utility.inputString());
			System.out.println("\n\t\t\tEnter the city");
			P.address.setCity(utility.inputString());
			System.out.println("\n\t\t\tEnter the ZipCode");
			P.address.setZip(utility.inputString());
			System.out.println("\n\t\t\tNew Address updated");
			break;
		}
	}
}


public void editPhoneNumber()
{
	String s = utility.inputString();
	for (Person P : list) {
	
	if (s.equals(P.getFirstName())) {
	System.out.println("\n\t\t\tEnter the new Phone Number");
	String phoneNumber = utility.inputString();
	P.setPhoneNumber(phoneNumber);
	System.out.println("\n\t\t\tNew Phone Number updated ");
	break;
	}
	}
}



ObjectMapper mapper = new ObjectMapper();
public void save(String fileName) {
	
	try {
		File file = new File("AddressBook/" + fileName + ".txt");
		System.out.println(file.getAbsolutePath());
		mapper.writeValue(file, list);
		System.out.println("\n\t\t\tSaved");
	} catch (JsonGenerationException e) {
		e.printStackTrace();
	} catch (JsonMappingException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
}



public void read(String existingAddressBook) throws Exception {
	ObjectMapper objectMapper = new ObjectMapper();
	try {
		BufferedReader reader = new BufferedReader(new FileReader("AddressBook/" + existingAddressBook + ".txt"));
		String arrayToJson;
		if ((arrayToJson = reader.readLine()) != null) {
			TypeReference<ArrayList<Person>> type = new TypeReference<ArrayList<Person>>() {
			};
			list = objectMapper.readValue(arrayToJson, type);
			reader.close();
		}
	} catch (IOException e) {
		e.printStackTrace();
	}

}

public void close(String existingAddressBook) {
	list.clear();
}


public void saveAs() {
	System.out.println("Enter the name of the new file");
	String fileNameNew = utility.inputString();
	save(fileNameNew);
	System.out.println("new file");
}
public Person add()
{
	Person person = new Person();
	Address address = new Address();
	System.out.println("Enter First Name");
	person.setFirstName(utility.inputString());
	//person.setFirstName(utility.inputString());
	System.out.println(person.getFirstName());
	System.out.println("Enter Last Name");
	person.setLastName(utility.inputString());
	System.out.println("Enter city");
	address.setCity(utility.inputString());
	System.out.println("Enter State");
	address.setState(utility.inputString());
	System.out.println("Enter ZipCode");
	address.setZip(utility.inputString());
	System.out.println("Enter Phone Number");
	person.setPhoneNumber(utility.inputString());
	person.setAddress(address);
	
	return person;
}
public void display() {
	for (Person p : list) {
		System.out.println(p.toString());
	}
}






}