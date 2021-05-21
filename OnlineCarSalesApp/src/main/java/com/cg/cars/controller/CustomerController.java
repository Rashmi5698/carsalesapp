package com.cg.cars.controller;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.cars.model.CustomerDTO;
import com.cg.cars.entities.Customer;

import com.cg.cars.services.CustomerService;

import com.cg.cars.exceptions.CustomerNotFoundException;
@RestController
@RequestMapping("/api/cars")
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	@PostMapping("/add-customer")
	public ResponseEntity<Object> insertcustomer(@RequestBody Customer customer)
	{
		CustomerDTO customerDTO = null;
		ResponseEntity<Object> customerResponse = null;
		customerDTO =customerService.addCustomer(customer);
		customerResponse = new ResponseEntity<Object>(customerDTO, HttpStatus.ACCEPTED);
		return customerResponse;
	}
	
	@GetMapping("/view-customer/{id}")
	public ResponseEntity getcustomerById(@PathVariable Long id) throws  CustomerNotFoundException {
	
		CustomerDTO customerDTO = customerService.getCustomerById(id);
		
		return new ResponseEntity(customerDTO, HttpStatus.OK);
	}
	@GetMapping("/view-all-customer")
	public List<CustomerDTO> viewAllCustomer() {
		
		return customerService.getAllCustomer();
	}
	

	@PutMapping("/update-customer/{id}")
	public ResponseEntity updatecustomer(@PathVariable Long id, @RequestBody Customer customerRequest) throws CustomerNotFoundException {
	
		customerService.updateCustomer(id,customerRequest);
		return new ResponseEntity("Updated ", HttpStatus.OK);

	}
	@DeleteMapping("/delete-customer/{id}")
	public ResponseEntity<Object> deleteCustomerById(@PathVariable Long id) throws CustomerNotFoundException{
	
		customerService.deleteCustomerById(id);
	
		return new ResponseEntity("deleted successfully:", HttpStatus.ACCEPTED);

	}

}
