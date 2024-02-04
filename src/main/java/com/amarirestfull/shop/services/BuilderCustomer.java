package com.amarirestfull.shop.services;

import com.amarirestfull.shop.domain.Customer;

//in this class i want to applied the builder design pattren 
// so that let's us to create an object step by step
// by in this case we don't need to create an object we just to change it's attribut
public class BuilderCustomer {
	private Customer customer;

	public BuilderCustomer(Customer customer) {
            this.customer=customer;
	}

	public BuilderCustomer buildFirstName(String fristName) {
		customer.setFirstName(fristName);
		return this;
	}

	public BuilderCustomer buildLastName(String lastName) {
		customer.setLastName(lastName);
		return this;
	}

	public BuilderCustomer buildStreet(String street) {
		customer.setStreet(street);
		return this;
	}

	public BuilderCustomer buildCity(String city) {
		customer.setCity(city);
		return this;
	}

	public BuilderCustomer buildState(String state) {
		customer.setState(state);
		return this;
	}

	public BuilderCustomer buildZip(String zip) {
		customer.setZip(zip);
		return this;
	}

	public BuilderCustomer buildCountry(String country) {
		customer.setCountry(country);
		return this;
	}

	public Customer build() {
		return this.customer;
	}

}
