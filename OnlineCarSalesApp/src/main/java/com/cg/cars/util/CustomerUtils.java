package com.cg.cars.util;

import com.cg.cars.model.CustomerDTO;

import com.cg.cars.entities.Customer;
import java.util.List;

import java.util.ArrayList;

public class CustomerUtils {
	private CustomerUtils() {
	}
	//converting into screen class
	public static List<CustomerDTO> convertToCustomerDtoList(List<Customer> list){
		List<CustomerDTO> dtolist=new ArrayList<CustomerDTO>();
		for(Customer customer :list)
			dtolist.add(convertToCustomerDto(customer));
		return dtolist;
}
	
	
	public static Customer convertToCustomer(CustomerDTO dto) {
		Customer customer= new Customer();
		customer.setUserId(dto.getUserId());
		customer.setName(dto.getName());
		customer.setEmail(dto.getEmail());
		customer.setContactNo(dto.getContactNo());
		customer.setDob(dto.getDob());
		//customer.setAddress(dto.getAddress());
		
	return customer;	
	}
	
	public static CustomerDTO convertToCustomerDto(Customer customer ) {
		CustomerDTO dto=new CustomerDTO();
		dto.setUserId(customer.getUserId());
		dto.setName(customer.getName());
		dto.setEmail(customer.getEmail());
		dto.setContactNo(customer.getContactNo());
		dto.setDob(customer.getDob());
		//dto.setAddress(customer.getAddress());
		
	return dto;	
	}
}
