package com.cg.cars.services;

import java.util.List;

import com.cg.cars.entities.Address;

import com.cg.cars.model.AddressDTO;



public interface AddressService {
	
	public AddressDTO addAddress(Address address);
	
	public AddressDTO getAddressById(int id);
	
	public List<AddressDTO> getAllAddress();
	
	public void deleteAddress(AddressDTO addressdto); 
	
	public void updateAddress(AddressDTO addressdto);
	


	
}