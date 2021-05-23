package com.cg.cars.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import com.cg.cars.entities.Address;
import com.cg.cars.exceptions.AddressNotFoundException;
import com.cg.cars.model.AddressDTO;

@RestController
@RequestMapping("/api/cars")
public class AddressController {
	static final Logger LOGGER = LoggerFactory.getLogger(AddressController.class);

	@Autowired
	private AddressService addressService;

	/************************************************************************************
	 * Method: addAddress
	 * Description: It is used to add Address into Address table
	 * @param Address: Address's reference variable.
	 * @returns Address It returns Address with details
	 * @PostMapping: It is used to handle the HTTP POST requests matched with given URI expression.
	 * @RequestBody: It used to bind the HTTP request/response body with a domain object in method parameter or return type.
	 ************************************************************************************/

	@PostMapping("/add-Address")
	public ResponseEntity<Object> insertAddress(@RequestBody Address address) {
		LOGGER.info("add-Address URL is opened");
		LOGGER.info("addAddress() is initiated");
		AddressDTO addressDTO = null;
		ResponseEntity<Object> addressResponse = null;
		addressDTO = addressService.addAddress(address);
		addressResponse = new ResponseEntity<Object>(addressDTO, HttpStatus.ACCEPTED);
		LOGGER.info("addAddress() has executed");
		return addressResponse;
	}

	/************************************************************************************
	 * Method: getAddressById 
	 * Description: It is used to view Address by id from Address table
	 * @param Address: Long id
	 * @returns Address It returns Address with details
	 * @GetMapping: It is used to handle the HTTP GET requests matched with given URI expression.
	 * @RequestBody: It used to bind the HTTP request/response body with a domain object in method parameter or return type.
	 ************************************************************************************/

	@GetMapping("/view-Address/{id}")
	public ResponseEntity getAddressById(@PathVariable Long id) throws AddressNotFoundException {
		LOGGER.info("view-Address URL is opened");
		LOGGER.info("getAddressById() is initiated");
		AddressDTO addressDTO = addressService.getAddressById(id);
		LOGGER.info("getAddressById() has executed");
		return new ResponseEntity(addressDTO, HttpStatus.OK);
	}

	/************************************************************************************
	 * Method: getAllAddresss 
	 * Description: It is used to view all Address in Address table
	 * @returns Address It returns Address with details
	 * @GetMapping: It is used to handle the HTTP GET requests matched with given URI expression.
	 * @RequestBody: It used to bind the HTTP request/response body with a domain object in method parameter or return type.
	 ************************************************************************************/
	@GetMapping("/view-all-Address")
	public List<AddressDTO> viewAllAddress() {
		LOGGER.info("view-add-Address URL is opened");
		LOGGER.info("getAllAddress() is initiated");
		LOGGER.info("getAllAddress() has executed");
		return addressService.getAllAddress();
	}

	/************************************************************************************
	 * Method: DeleteAddress 
	 * Description: It is used to remove Address from Address table
	 * @param Address: Long id
	 * @returns Address It returns Address with details
	 * @DeleteMapping: It is used to handle the HTTP DELETE requests matched with given URI expression.
	 * @RequestBody: It used to bind the HTTP request/response body with a domain object in method parameter or return type.
	 ************************************************************************************/
	@DeleteMapping("/delete-Address/{id}")
	public ResponseEntity<Object> deleteAddressById(@PathVariable Long id) throws AddressNotFoundException {
		LOGGER.info("delete-Address URL is opened");
		LOGGER.info("deleteAddress() is initiated");
		addressService.deleteAddressById(id);
		LOGGER.info("deleteAddress() has executed");
		return new ResponseEntity("deleted successfully:", HttpStatus.ACCEPTED);
	}

	/************************************************************************************
	 * Method: updateAddress 
	 * Description: It is used to update Address into Address table
	 * @param Address: Long id
	 * @returns Address It returns Address with details
	 * @PutMapping: It is used to handle the HTTP PUT requests matched with given URI expression.
	 * @RequestBody: It used to bind the HTTP request/response body with a domain object in method parameter or return type.
	 ************************************************************************************/

	@PutMapping("/update-Address/{id}")
	public ResponseEntity updateAddress(@PathVariable Long id, @RequestBody Address addressRequest)
			throws AddressNotFoundException {
		LOGGER.info("update-Address URL is opened");
		LOGGER.info("updateAddress() is initiated");
		addressService.updateAddressById(id, addressRequest);
		LOGGER.info("updateAddress() has executed");
		return new ResponseEntity("Updated ", HttpStatus.OK);
	}

}
