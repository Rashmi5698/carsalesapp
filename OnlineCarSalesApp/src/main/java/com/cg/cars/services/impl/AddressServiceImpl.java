package com.cg.cars.services.impl;

import java.util.List;
import java.util.Optional;

import com.cg.cars.entities.Address;

import com.cg.cars.model.AddressDTO;

import com.cg.cars.services.AddressService;
import com.cg.cars.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.cars.util.AddressUtils;


@Service
public class AddressServiceImpl implements AddressService{
	
	@Autowired
	private AddressRepository addressRepository;
	
	
public AddressDTO addAddress(Address address){
	Address addressEntity=addressRepository.save(address);
	return AddressUtils.convertToAddressDto(addressEntity);
}


public void deleteAddress(AddressDTO addressdto) {
	
	addressRepository.delete(AddressUtils.convertToAddress(addressdto));
	
}
	
public void updateAddress(AddressDTO addressdto) {
	
	addressRepository.save(AddressUtils.convertToAddress(addressdto));
			
	
}

public AddressDTO getAddressById(int id) {
	Optional<Address> existAddress=addressRepository.findById(id);
	if(existAddress.isPresent()) {
		Address address=existAddress.get();
	return AddressUtils.convertToAddressDto(address);
}
	else {
		return null;
	}
	
}


public List<AddressDTO> getAllAddress(){
		List<Address> addressList=addressRepository.findAll();
		return AddressUtils.convertToAddressDtoList(addressList);
		}
}





