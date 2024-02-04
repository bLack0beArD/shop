package com.amarirestfull.shop.services;

import java.util.HashSet;
import java.util.Set;

import jakarta.ws.rs.core.Application;

public class ShoppingApplication extends Application {
	private Set<Object> singletons = new HashSet<Object>();
	private Set<Class<?>> empty = new HashSet<Class<?>>();

	public ShoppingApplication() {
		singletons.add(new CustomerResource());
	}

	@Override
	public Set<Class<?>> getClasses() {
		return empty;
	}

	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}
}
