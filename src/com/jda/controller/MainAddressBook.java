package com.jda.controller;

import com.jda.model.Person;
import com.jda.services.AddressBookManager;
import com.jda.services.AddressBookMethods;
import com.jda.utility.Utility2;

public class MainAddressBook{

	public static void main(String[] args) throws Exception {
		Utility2 utility = new Utility2();
		System.out.println("Hello addressBook");
		AddressBookManager addressBookManager = new AddressBookManager();
		String existingAddressBook = "";
		
		
		
		boolean bool = true;
		

		while (bool) {
			AddressBookMethods addressBook = new AddressBookMethods();
			System.out.println("hello enter");
			System.out.println("Enter choice for address book");
			System.out.println("1 - create new addressbook, 2 - editing existing adressbook, 3 - save the adressbook, 4- save as different name, 5- closing the addressbook");
			
			int choice = utility.inputInteger();
			switch (choice) {
			case 1:
				existingAddressBook = addressBookManager.create();
				addressBookManager.close(existingAddressBook);
				break;
			case 2:
				addressBookManager.close(existingAddressBook);
				addressBookManager.readAddress();
				System.out.println("\n\t\t\tEnter the name of the address book\n");
				existingAddressBook = utility.inputString();
				if (addressBookManager.checkAddress(existingAddressBook)) {
					System.out.println("\t\t\tFile Exists\n");
					System.out.println("Reading existing file");
					addressBookManager.read(existingAddressBook);
					boolean bool1 = true;
					
					while (bool1) {
						System.out.println("Enter the choice");
						System.out.println("Enter 1- add, 2- remove, 3 - sort by name, 4 - display, 5 - main menu, 6-sort by zip , 7- edit phone number, 8-edit address");
						int choose = utility.inputInteger();
						
						switch (choose) {
						case 1:
							addressBook.adding();
							break;
						
						
						case 2:
							addressBook.remove();
							break;
						case 3:
							addressBook.sortByName();
							break;
						
						case 4:
							addressBook.display();
							break;
						case 5:
							System.out.println(" Main Menu");
							bool1 = false;
							break;
						case 6:
							addressBook.sortByZip();
							break;
						case 7:
							//Person P = new Person();
							System.out.println("Enter the first name whose phone number is o be edited");
							// String s = utility.inputString();
							//s =  P.getFirstName();
							addressBook.editPhoneNumber();
							break;
						case 8:
							//Person p = new Person();
							System.out.println("Enter the first name whose phone number is o be edited");
							// String s1 = utility.inputString();
							// s1 = p.getFirstName();
							 addressBook.editAddress();
							 break;
						
						default:
							System.out.println("\t\t\tWrong data\n" + "\t\t\tAddress Book named '" + existingAddressBook
									+ "' closed\n");
							addressBook.close(existingAddressBook);
							bool1= false;
							break;

						}
					}
				} else {
					System.out.println("\t\t\tEntered filename doesn't exist");
				}
				break;
			case 3:
				addressBookManager.save(existingAddressBook);
				break;
			case 4:
				addressBookManager.saveAs();
				break;
			case 5:
				System.out.println("Closing Address Book\n");
				bool = false;
				break;
			default:
				System.out.println("something wrong" + "\t\t\tAddress Book closed\n");
				bool = false;
				break;
			}
		}
	}
}
