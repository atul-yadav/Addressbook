package com.jda.model;


public class Address {
	String city;
	String state;
	String zip;
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String string) {
		this.state = string;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	@Override
	public String toString() {
		return "\n\t\t\t\t   City  : " + city + "\n\t\t\t\t   State : " + state + "\n\t\t\t\t   Zip   : " + zip ;
	}
	
}
