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

import com.cg.cars.services.CustomerService;
import com.cg.cars.services.CustomerService;
import com.cg.cars.model.CustomerDTO;
import com.cg.cars.model.CustomerDTO;
import com.cg.cars.entities.Customer;
import com.cg.cars.entities.Customer;

//@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/api/cars")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	@PostMapping("/add-customer")
	public ResponseEntity<Object> insertCustomer(@RequestBody Customer customer)
	{
		CustomerDTO customerDTO = null;
		ResponseEntity<Object> customerResponse = null;
		customerDTO =customerService.addCustomer(customer);
		customerResponse = new ResponseEntity<Object>(customerDTO, HttpStatus.ACCEPTED);
		return customerResponse;
	}
	@GetMapping("/view-customer/{id}")
	public ResponseEntity getCustomer(@PathVariable int id) {
	
		CustomerDTO customerDTO = customerService.getCustomerById(id);
		
		return new ResponseEntity(customerDTO, HttpStatus.OK);
	}
	
	
	@GetMapping("/view-all-customers")
	public List<CustomerDTO> viewAllCustomers() {
		
		return customerService.getAllCustomers();
	}
	
	@DeleteMapping("/delete-customer")
	public ResponseEntity deleteCustomer(@RequestBody CustomerDTO customerdto){
	 customerService.deleteCustomer(customerdto);
	return new ResponseEntity("deleted successfully:",HttpStatus.OK);
		
		
	}
	
	@PutMapping("/update-customer")
	public ResponseEntity updateCustomer(@RequestBody CustomerDTO customerdto) {
		customerService.updateCustomer(customerdto);
		return new ResponseEntity("Updated ", HttpStatus.OK);
		

	}
}
