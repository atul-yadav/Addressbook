package com.jda.services;

import java.util.Comparator;

import com.jda.model.Address;
import com.jda.model.Person;


	public  class SortByZip implements Comparator<Person> {

		public int compare(Person p1, Person p2) {
			if(p1.address.getZip().equals(p2.address.getZip()))
				return 0;
			else {
				if(p1.address.getZip().compareTo(p2.address.getZip())>0) {
					return 1;
				}else {
					return -1;
				}
			}
		}

	
	}

