package com.cg.cars.services.impl;

import java.util.List;
import java.util.Optional;
import com.cg.cars.entities.Address;
import com.cg.cars.services.AddressService;
import com.cg.cars.util.AddressUtils;
import com.cg.cars.repository.AddressRepository;
import com.cg.cars.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.cars.exceptions. AddressNotFoundException;

import com.cg.cars.model.AddressDTO;


@Service
public class AddressServiceImpl implements AddressService{
	@Autowired
	 private CustomerRepository customerRepository;
	@Autowired
	    private AddressRepository addressRepository;

	    @Override
	    public void addAddress(Long userId,Address address) {
	        customerRepository.findById(userId).map(customers -> {
	            address.getCustomers().add(customers);
	            return addressRepository.save(address);
	        });
	    }

	    public List<AddressDTO> getAllAddress(){
			List<Address> addressList=addressRepository.findAll();
			return AddressUtils.convertToAddressDtoList(addressList);
			}

	public AddressDTO deleteAddressById(Long id)throws AddressNotFoundException {
		Address addressexist=addressRepository.findById(id).orElse(null);
		if(addressexist==null)
			throw new AddressNotFoundException("Address with id not present");
		else
			addressRepository.delete(addressexist);
		return AddressUtils.convertToAddressDto(addressexist);
		}



	public Address updateAddressById(Long id, Address addressRequest) throws AddressNotFoundException{
	    return addressRepository.findById(id).map( address-> {
	    	 address.setDoorNo(addressRequest.getDoorNo());
	            address.setStreet(addressRequest.getStreet());
	            address.setArea(addressRequest.getArea());
	            address.setCity(addressRequest.getCity());
	            address.setState(addressRequest.getState());
	            address.setPincode(addressRequest.getPincode());
	            return addressRepository.save(address);
	    	
	    }).orElseThrow(()-> new AddressNotFoundException("Address with id not present"));
	    
	}
	public AddressDTO getAddressById(Long id) throws AddressNotFoundException{
    	Optional<Address> existAddress=addressRepository.findById(id);
    	if(existAddress.isPresent()) {
    		Address address=existAddress.get();
    	return AddressUtils.convertToAddressDto(address);
    }
    	else {
    		return null;
    	}
    	
    }
	public AddressDTO addAddress(Address address){
		Address addressEntity=addressRepository.save(address);
		return AddressUtils.convertToAddressDto(addressEntity);
	}

	   /* @Override
	    public void deleteAddress(Long userId, Long addressId) throws AddressNotFoundException  {
	        if (!customerRepository.existsById(userId)) {
	            throw new AddressNotFoundException("Address with id not found");
	        }
	        addressRepository.findById(addressId).map(address -> {
	            addressRepository.delete(address);
	            return address;
	        });
	    }
	  

	    @Override
	    public void updateAddress(Long userId, Address addressRequest) throws AddressNotFoundException{
	        if (!customerRepository.existsById(userId)) {
	            throw new AddressNotFoundException("address with id not found");
	        }
	        addressRepository.findById(addressRequest.getAddressId()).map(address -> {
	        	//address.setAddressId(addressRequest.getAddressId());
	            address.setDoorNo(addressRequest.getDoorNo());
	            address.setStreet(addressRequest.getStreet());
	            address.setArea(addressRequest.getArea());
	            address.setCity(addressRequest.getCity());
	            address.setState(addressRequest.getState());
	            address.setPincode(addressRequest.getPincode());
	            return addressRepository.save(address);
	        });

	    }*/
	    

}

