package com.jda.services;

import java.util.Comparator;

import com.jda.model.Person;

public  class SortByName implements Comparator<Person> {

	public int compare(Person personOne, Person personTwo) {
		if(personOne.getFirstName().equals(personTwo.getFirstName()))
			return 0;
		else {
			if(personOne.getFirstName().compareTo(personTwo.getFirstName())>0) {
				return 1;
			}else {
				return -1;
			}
		}
	}
}
