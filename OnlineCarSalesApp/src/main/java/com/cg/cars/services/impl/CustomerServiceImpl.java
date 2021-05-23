package com.cg.cars.services.impl;

import java.util.List;
import java.util.Optional;

import com.cg.cars.entities.Car;
import com.cg.cars.entities.Customer;
import com.cg.cars.exceptions.CustomerNotFoundException;
import com.cg.cars.model.CustomerDTO;
import com.cg.cars.services.CustomerService;
import com.cg.cars.repository.CustomerRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.cars.util.CustomerUtils;

@Service
public class CustomerServiceImpl implements CustomerService {
	static final Logger LOGGER = LoggerFactory.getLogger(CustomerServiceImpl.class);
	@Autowired
	private CustomerRepository customerRepository;

	public CustomerDTO addCustomer(Customer customer) {
		LOGGER.info("addCustomer() service is initiated");
		Customer customerEntity = customerRepository.save(customer);
		LOGGER.info("addCustomer() service has executed");
		return CustomerUtils.convertToCustomerDto(customerEntity);
	}

	public CustomerDTO deleteCustomerById(Long id) throws CustomerNotFoundException {
		LOGGER.info("deleteCustomer() service is initiated");
		Customer customerexist = customerRepository.findById(id).orElse(null);
		if (customerexist == null)
			throw new CustomerNotFoundException("customer with id not present");
		else
			customerRepository.delete(customerexist);
		LOGGER.info("deleteCustomer() service has executed");
		return CustomerUtils.convertToCustomerDto(customerexist);
	}

	public Customer updateCustomer(Long id, Customer customerRequest) throws CustomerNotFoundException {
		LOGGER.info("updateCustomer() service is initiated");
		return customerRepository.findById(id).map(customers -> {
			customers.setName(customerRequest.getName());
			customers.setEmail(customerRequest.getEmail());
			customers.setContactNo(customerRequest.getContactNo());
			customers.setDob(customerRequest.getDob());
			LOGGER.info("updateCustomer() service has executed");
			return customerRepository.save(customers);
		}).orElseThrow(() -> new CustomerNotFoundException("Customer with id not present"));

	}

	public CustomerDTO getCustomerById(Long id) throws CustomerNotFoundException {
		LOGGER.info("getCustomerById() service is initiated");
		Optional<Customer> existCustomer = customerRepository.findById(id);
		if (existCustomer.isPresent()) {
			Customer customer = existCustomer.get();
			LOGGER.info("getCustomerById() service has executed");
			return CustomerUtils.convertToCustomerDto(customer);
		} else {
			throw new CustomerNotFoundException("Customer with id not found");
		}
	}

	public List<CustomerDTO> getAllCustomer() {
		LOGGER.info("getAllCustomer() service is initiated");
		List<Customer> customerList = customerRepository.findAll();
		LOGGER.info("getAllCustomer() service has executed");
		return CustomerUtils.convertToCustomerDtoList(customerList);
	}

}
