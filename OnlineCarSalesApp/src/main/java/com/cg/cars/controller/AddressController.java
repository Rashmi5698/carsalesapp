package com.cg.cars.controller;
import java.util.List;


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
import com.cg.cars.services.AddressService;
import com.cg.cars.services.AddressService;
import com.cg.cars.model.AddressDTO;
import com.cg.cars.model.AddressDTO;
import com.cg.cars.entities.Address;
import com.cg.cars.entities.Address;

//@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/api/cars")
public class AddressController {
	
	@Autowired
	private AddressService addressService;
	@PostMapping("/add-address")
	public ResponseEntity<Object> insertAddress(@RequestBody Address address)
	{
		AddressDTO addressDTO = null;
		ResponseEntity<Object> addressResponse = null;
		addressDTO =addressService.addAddress(address);
		addressResponse = new ResponseEntity<Object>(addressDTO, HttpStatus.ACCEPTED);
		return addressResponse;
	}
	@GetMapping("/view-address/{id}")
	public ResponseEntity getAddressById(@PathVariable int id) {
	
		AddressDTO addressDTO = addressService.getAddressById(id);
		
		return new ResponseEntity(addressDTO, HttpStatus.OK);
	}
	
	
	@GetMapping("/view-all-address")
	public List<AddressDTO> viewAllAddress() {
		
		return addressService.getAllAddress();
	}
	
	@DeleteMapping("/delete-address")
	public ResponseEntity deleteAddress(@RequestBody AddressDTO addressdto){
	 addressService.deleteAddress(addressdto);
	return new ResponseEntity("deleted successfully:",HttpStatus.OK);
		
		
	}
	
	@PutMapping("/update-address")
	public ResponseEntity updateAddress(@RequestBody AddressDTO addressdto) {
		addressService.updateAddress(addressdto);
		return new ResponseEntity("Updated ", HttpStatus.OK);
		

	}
	

}
