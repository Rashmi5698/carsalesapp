package com.cg.cars.services;

import java.util.List;

import com.cg.cars.entities.Address;

import com.cg.cars.model.AddressDTO;

import com.cg.cars.exceptions.AddressNotFoundException;


public interface AddressService {
	
	public void addAddress(Long userId, Address address);

	   public List<AddressDTO> getAllAddress();
	   
	   public AddressDTO deleteAddressById(Long id)throws AddressNotFoundException;
	   
	   public Address updateAddressById(Long id, Address addressRequest) throws AddressNotFoundException;
	   //public void updateAddress(Long userId, Address addressRequest) throws AddressNotFoundException;
	
	  public AddressDTO getAddressById(Long id)throws AddressNotFoundException;
	
	  public AddressDTO addAddress(Address address);
	 // public void deleteAddress(Long userId, Long addressId) throws AddressNotFoundException;

	
}