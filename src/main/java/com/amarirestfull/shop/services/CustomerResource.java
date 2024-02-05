package com.amarirestfull.shop.services;


import java.net.URI;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import com.amarirestfull.shop.domain.Customer;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;


@Path("customer")
public class CustomerResource {
	//we use the those atributes as static because if we did'nt do this 
	// so there is no saving of data in memory 
	//because this framework create an object for each request
	private static Map<Integer, Customer> customerDB = new ConcurrentHashMap<Integer, Customer>();
	private static AtomicInteger idCounter = new AtomicInteger(0);

	// @Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@POST
	public Response createCustomer(Customer customer) {
		if(customer==null)System.out.println("null");
		// Customer customer = OperationsCustomer.readCustomer(inputStream);
		customer.setId(idCounter.incrementAndGet());
		customerDB.put(customer.getId(), customer);
		// Response response =
		// Response.created(URI.create("customer/"+idCounter.get())).build();
		return Response.created(URI.create("customer/" + idCounter.get())).build();
	}

	@Produces(MediaType.APPLICATION_JSON)
	@GET
	@Path("/{id}")
	public Customer getCustomer(@PathParam("id") int id) {
		Customer customer = customerDB.get(id);
		System.out.println(id);
		if (customer == null) {
			throw new WebApplicationException(404);
		}

		return customer;
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public void updateCustomer(Customer newCustomer, @PathParam("id") int id) {
		Customer oldCustomer = getCustomerById(id);
		if (oldCustomer == null)
			throw new WebApplicationException(404);
		FillCustomer.sendDeta(oldCustomer, newCustomer);

	}

	private Customer getCustomerById(int id) {
		return customerDB.get(id);
	}
}
