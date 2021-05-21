package com.cg.cars.services.impl;


import java.util.List;
import java.util.Optional;
import com.cg.cars.entities.Customer;
import com.cg.cars.exceptions.CustomerNotFoundException;
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
	
	
public CustomerDTO addCustomer(Customer customer){
	Customer customerEntity=customerRepository.save(customer);
	return CustomerUtils.convertToCustomerDto(customerEntity);
}
public CustomerDTO deleteCustomerById(Long id)throws CustomerNotFoundException {
	Customer customerexist=customerRepository.findById(id).orElse(null);
	if(customerexist==null)
		throw new CustomerNotFoundException("customer with id not present");
	else
		customerRepository.delete(customerexist);
	return CustomerUtils.convertToCustomerDto(customerexist);
	}



public Customer updateCustomer(Long id, Customer customerRequest) throws CustomerNotFoundException{
    return customerRepository.findById(id).map( customers-> {
    	customers.setName(customerRequest.getName());
		customers.setEmail(customerRequest.getEmail());
		customers.setContactNo(customerRequest.getContactNo());
		customers.setDob(customerRequest.getDob());
    return customerRepository.save(customers);
    }).orElseThrow(()-> new CustomerNotFoundException("Customer with id not present"));
    
}
	

public CustomerDTO getCustomerById(Long id) throws  CustomerNotFoundException {
	Optional<Customer> existCustomer=customerRepository.findById(id);
	if(existCustomer.isPresent()) {
		Customer customer=existCustomer.get();
	return CustomerUtils.convertToCustomerDto(customer);
}
	else {
		throw new  CustomerNotFoundException("Customer with id not found");
	}
}

	public List<CustomerDTO> getAllCustomer(){
		List<Customer> customerList=customerRepository.findAll();
		return CustomerUtils.convertToCustomerDtoList(customerList);
		}

}

