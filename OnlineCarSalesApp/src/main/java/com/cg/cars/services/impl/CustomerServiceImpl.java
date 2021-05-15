package com.cg.cars.services.impl;

import java.util.List;
import java.util.Optional;

import com.cg.cars.entities.Customer;

import com.cg.cars.model.CustomerDTO;

import com.cg.cars.services.CustomerService;
import com.cg.cars.repository.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.cg.cars.util.CustomerUtils;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerRepository customerRepository;
	
public CustomerDTO addCustomer(Customer customer) {
	Customer customerEntity=customerRepository.save(customer);
	return CustomerUtils.convertToCustomerDto(customerEntity);
}


public void deleteCustomer(CustomerDTO customerdto) {
	
	customerRepository.delete(CustomerUtils.convertToCustomer(customerdto));
	
}
	
public void updateCustomer(CustomerDTO customerdto) {
	
	customerRepository.save(CustomerUtils.convertToCustomer(customerdto));	
}

public CustomerDTO getCustomerById(int id) {
	Optional<Customer> existCustomer=customerRepository.findById(id);
	if(existCustomer.isPresent()) {
		Customer customer=existCustomer.get();
	return CustomerUtils.convertToCustomerDto(customer);
}
	else {
		return null;
	}
	
}


public List<CustomerDTO> getAllCustomers(){
		List<Customer> customerList=customerRepository.findAll();
		return CustomerUtils.convertToCustomerDtoList(customerList);
		}




}

