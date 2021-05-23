package com.cg.cars.services.impl;

import java.util.List;
import java.util.Optional;
import com.cg.cars.entities.Address;
import com.cg.cars.services.AddressService;
import com.cg.cars.util.AddressUtils;
import com.cg.cars.repository.AddressRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.cars.exceptions.AddressNotFoundException;

import com.cg.cars.model.AddressDTO;

@Service
public class AddressServiceImpl implements AddressService {

	static final Logger LOGGER = LoggerFactory.getLogger(AddressServiceImpl.class);
	@Autowired
	private AddressRepository addressRepository;

	public List<AddressDTO> getAllAddress() {
		LOGGER.info("getAddress() service is initiated");
		List<Address> addressList = addressRepository.findAll();
		LOGGER.info("getAddress() service has executed");
		return AddressUtils.convertToAddressDtoList(addressList);
	}

	public AddressDTO deleteAddressById(Long id) throws AddressNotFoundException {
		LOGGER.info("deleteAddress() service is initiated");
		Address addressexist = addressRepository.findById(id).orElse(null);
		if (addressexist == null)
			throw new AddressNotFoundException("Address with id not present");
		else
			addressRepository.delete(addressexist);
		LOGGER.info("deleteAddress() service has executed");
		return AddressUtils.convertToAddressDto(addressexist);
	}

	public Address updateAddressById(Long id, Address addressRequest) throws AddressNotFoundException {
		LOGGER.info("updateAddress() service is initiated");
		return addressRepository.findById(id).map(address -> {
			address.setDoorNo(addressRequest.getDoorNo());
			address.setStreet(addressRequest.getStreet());
			address.setArea(addressRequest.getArea());
			address.setCity(addressRequest.getCity());
			address.setState(addressRequest.getState());
			address.setPincode(addressRequest.getPincode());
			LOGGER.info("updateAddress() service has executed");
			return addressRepository.save(address);

		}).orElseThrow(() -> new AddressNotFoundException("Address with id not present"));

	}

	public AddressDTO getAddressById(Long id) throws AddressNotFoundException {
		LOGGER.info("getByIdAddress() service is initiated");
		Optional<Address> existAddress = addressRepository.findById(id);
		if (existAddress.isPresent()) {
			Address address = existAddress.get();
			LOGGER.info("getByIdAddress() service has executed");
			return AddressUtils.convertToAddressDto(address);
		} else {
			return null;
		}

	}

	public AddressDTO addAddress(Address address) {
		LOGGER.info("addAddress() service is initiated");
		Address addressEntity = addressRepository.save(address);
		LOGGER.info("addAddress() service has executed");
		return AddressUtils.convertToAddressDto(addressEntity);
	}

}
