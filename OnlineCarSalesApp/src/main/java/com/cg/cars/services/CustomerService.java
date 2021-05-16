package com.cg.cars.services;

import java.util.List;


import com.cg.cars.entities.Customer;

import com.cg.cars.model.CustomerDTO;


public interface CustomerService {
	
	public CustomerDTO addCustomer(Customer customer);
	
	public void deleteCustomer(CustomerDTO customerdto);

	public CustomerDTO getCustomerById(int id);
	
	public List<CustomerDTO> getAllCustomers();
	
	public void updateCustomer(CustomerDTO customerdto);
	
	//public Customer removeCustomer(long custId);
	
	//public Customer updateCustomer(long custId, Customer customer);
	
	//public List<Customer> getCustomersByLocation();

	
}