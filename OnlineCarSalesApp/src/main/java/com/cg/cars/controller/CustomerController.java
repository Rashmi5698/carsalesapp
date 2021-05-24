package com.cg.cars.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	static final Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);
	@Autowired
	private CustomerService customerService;

	/************************************************************************************
	 * Method: addCustomer 
	 * Description: It is used to add Customer into Customers table
	 * @param Customer: Customer's reference variable.
	 * @returns Customer: It returns Customer with details
	 * @PostMapping: It is used to handle the HTTP POST requests matched with given URI expression.
	 * @RequestBody: It used to bind the HTTP request/response body with a domain object in method parameter or return type.
	 ************************************************************************************/
	@PostMapping("/add-customer")
	public ResponseEntity<Object> insertcustomer(@RequestBody Customer customer) {
		LOGGER.info("add-Customer URL is opened");
		LOGGER.info("addCustomer() is initiated");
		CustomerDTO customerDTO = null;
		ResponseEntity<Object> customerResponse = null;
		customerDTO = customerService.addCustomer(customer);
		customerResponse = new ResponseEntity<>(customerDTO, HttpStatus.ACCEPTED);
		LOGGER.info("addCustomer() has executed");
		return customerResponse;
	}

	/************************************************************************************
	 * Method: getCustomerById 
	 * Description: It is used to view Customer by id from Customers table
	 * @param Customer: Long id
	 * @returns Customer: It returns Customer with details
	 * @GetMapping: It is used to handle the HTTP GET requests matched with given URI expression.
	 * @RequestBody: It used to bind the HTTP request/response body with a domain object in method parameter or return type.
	 ************************************************************************************/
	@GetMapping("/view-customer/{id}")
	public ResponseEntity<Object> getcustomerById(@PathVariable Long id) throws CustomerNotFoundException {
		LOGGER.info("view-Customer URL is opened");
		LOGGER.info("viewCustomer() is initiated");
		CustomerDTO customerDTO = customerService.getCustomerById(id);
		LOGGER.info("viewCustomer() has executed");
		return new ResponseEntity<>(customerDTO, HttpStatus.OK);
	}

	/************************************************************************************
	 * Method: getAllCustomers 
	 * Description: It is used to view all Customers in Customers table
	 * @returns Customer: It returns Customer with details
	 * @GetMapping: It is used to handle the HTTP GET requests matched with given URI expression.
	 * @RequestBody: It used to bind the HTTP request/response body with a domain object in method parameter or return type.
	 ************************************************************************************/
	@GetMapping("/view-all-customer")
	public List<CustomerDTO> viewAllCustomer() {
		LOGGER.info("view-all-Customer URL is opened");
		LOGGER.info("viewAllCustomer() is initiated");
		LOGGER.info("viewAllCustomer() has executed");
		return customerService.getAllCustomer();
	}

	/************************************************************************************
	 * Method: updateCustomer 
	 * Description: It is used to update Customer into Customer table
	 * @param Customer: Customer's reference variable.
	 * @returns Customer: It returns Customer with details
	 * @PutMapping: It is used to handle the HTTP PUT requests matched with given URI expression.
	 * @RequestBody: It used to bind the HTTP request/response body with a domain object in method parameter or return type.
	 ************************************************************************************/

	@PutMapping("/update-customer/{id}")
	public ResponseEntity<Object> updatecustomer(@PathVariable Long id, @RequestBody Customer customerRequest)
			throws CustomerNotFoundException {
		LOGGER.info("update-Customer URL is opened");
		LOGGER.info("updateCustomer() is initiated");
		customerService.updateCustomer(id, customerRequest);
		LOGGER.info("updateCustomer() has executed");
		return new ResponseEntity<>("Updated ", HttpStatus.OK);

	}

	/************************************************************************************
	 * Method: DeleteCustomer 
	 * Description: It is used to remove Customer from Customers table
	 * @param Customer: Long id
	 * @returns Customer: It returns Customer with details
	 * @DeleteMapping: It is used to handle the HTTP DELETE requests matched with given URI expression.
	 * @RequestBody: It used to bind the HTTP request/response body with a domain object in method parameter or return type.
	 ************************************************************************************/
	@DeleteMapping("/delete-customer/{id}")
	public ResponseEntity<Object> deleteCustomerById(@PathVariable Long id) throws CustomerNotFoundException {
		LOGGER.info("delete-Customer URL is opened");
		LOGGER.info("deleteCustomer() is initiated");
		customerService.deleteCustomerById(id);
		LOGGER.info("delteCustomer() has executed");
		return new ResponseEntity<>("deleted successfully:", HttpStatus.ACCEPTED);

	}

}
