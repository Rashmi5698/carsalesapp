package com.cg.cars.services;

import java.util.List;

import com.cg.cars.entities.Customer;
import com.cg.cars.exceptions.CustomerNotFoundException;
import com.cg.cars.model.CustomerDTO;

public interface CustomerService {

	public CustomerDTO addCustomer(Customer customer);

	public CustomerDTO getCustomerById(Long id) throws CustomerNotFoundException;

	public List<CustomerDTO> getAllCustomer();

	public CustomerDTO deleteCustomerById(Long id) throws CustomerNotFoundException;

	public Customer updateCustomer(Long id, Customer customerRequest) throws CustomerNotFoundException;

}