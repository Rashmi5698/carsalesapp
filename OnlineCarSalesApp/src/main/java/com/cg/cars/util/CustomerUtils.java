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
	
	
	/*public static Customer convertToCustomer(CustomerDTO dto) {
		Customer customer= new Customer();
		customer.setUserId(dto.getUserId());
		customer.setName(dto.getName());
		customer.setEmail(dto.getEmail());
		customer.setContactNo(dto.getContactNo());
		customer.setDob(dto.getDob());
		customer.setAppointment(dto.getAppointment());
		customer.setAddress(dto.getAddress());
		customer.setIorder(dto.getIorder());
		customer.setCar(dto.getCar());
		customer.setUser(dto.getUser());
		
		
	return customer;	
	}*/
	
	public static CustomerDTO convertToCustomerDto(Customer customer ) {
		CustomerDTO dto=new CustomerDTO();
		dto.setUserId(customer.getUserId());
		dto.setName(customer.getName());
		dto.setEmail(customer.getEmail());
		dto.setContactNo(customer.getContactNo());
		dto.setDob(customer.getDob());
		dto.setUser(customer.getUser());
		dto.setAppointment(dto.getAppointment());
		dto.setAddress(customer.getAddress());
		dto.setIorder(customer.getIorder());
		dto.setCar(customer.getCar());
		dto.setUser(customer.getUser());
	return dto;	
	}
}
