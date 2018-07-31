package com.jda.services;

import com.jda.utility.Utility2;

import java.io.File;
import java.io.IOException;

public class AddressBookManager {
public String create() throws IOException {
		Utility2 utility = new Utility2();
		System.out.println("Enter the name of address book");
		String NewAddressBookName = utility.inputString();
		File file = new File("AddressBook//" + NewAddressBookName + ".txt");
		if (file.createNewFile()) {
			System.out.println("File is created!");
		} else {
			System.out.println("File already exists.");
		}
		return NewAddressBookName;
	}

	
	public void save(String file) {
		AddressBookMethods abm = new AddressBookMethods();
		abm.save(file);
	}

	
	public void read(String existingAddressBook) throws Exception {
		AddressBookMethods abm = new AddressBookMethods();
		abm.read(existingAddressBook);
	}

	
	public void readAddress() {
		File f = new File("AddressBook/");
		int count = 0;
		for (File file : f.listFiles()) {
			if (file.isFile()) {
				System.out.println("\t\n"+file.getName());
				count++;
			}
		}
	}

	
	public boolean checkAddress(String existingAddressBook) {
		File f = new File("AddressBook/");
		int count = 0;
		for (File file : f.listFiles()) {
			if (file.isFile()) {
				if (file.getName().equals(existingAddressBook + ".txt")) {
					count++;
					break;
				}
			}
		}
		if (count == 1)
			return true;
		else
			return false;
	}

	
	public void close(String existingAddressBook) {
		AddressBookMethods ab = new AddressBookMethods();
		ab.close(existingAddressBook);
	}

	
	public void saveAs() {
		AddressBookMethods ab = new AddressBookMethods();
		ab.saveAs();
		
	}
	}