package com.amarirestfull.shop.services;

import com.amarirestfull.shop.domain.Customer;

public class FillCustomer {
	//this a way to to change data of a customer object 
	// i used this method in an new class for to avoid repetition on the customer resource class
	public static void sendDeta(Customer oldCustomer ,Customer newCustomer) {
		BuilderCustomer bc =new BuilderCustomer(oldCustomer);
		bc.buildFirstName(newCustomer.getFirstName())
		.buildLastName(newCustomer.getLastName())
		.buildCity(newCustomer.getCity())
		.buildStreet(newCustomer.getStreet())
		.buildState(newCustomer.getState())
		.buildZip(newCustomer.getZip())
		.buildCountry(newCustomer.getCountry());
	}
	
}
