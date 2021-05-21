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
import com.cg.cars.entities.Address;
import com.cg.cars.exceptions.AddressNotFoundException;
import com.cg.cars.model.AddressDTO;



@RestController
@RequestMapping("/api/cars")
public class AddressController {
	
	@Autowired
    private AddressService addressService;

    @PostMapping("/customer/{userId}/address")
    public ResponseEntity<Object> createAddress(@PathVariable(value = "userId") Long userId,
                                       @RequestBody Address address) {
        addressService.addAddress(userId, address);
        return new ResponseEntity<Object>(address, HttpStatus.CREATED);
    }
    @PostMapping("/add-Address")
	public ResponseEntity<Object> insertAddress(@RequestBody Address address)
	{
		AddressDTO addressDTO = null;
		ResponseEntity<Object> addressResponse = null;
		addressDTO =addressService.addAddress(address);
		addressResponse = new ResponseEntity<Object>(addressDTO, HttpStatus.ACCEPTED);
		return addressResponse;
	}
	@GetMapping("/view-Address/{id}")
	public ResponseEntity getAddressById(@PathVariable Long id) throws  AddressNotFoundException{
	
		AddressDTO addressDTO = addressService.getAddressById(id);
		
		return new ResponseEntity(addressDTO, HttpStatus.OK);
	}
	
	
	@GetMapping("/view-all-Address")
	public List<AddressDTO> viewAllAddress() {
		
		return addressService.getAllAddress();
	}
	@DeleteMapping("/delete-Address/{id}")
	public ResponseEntity<Object> deleteAddressById(@PathVariable Long id) throws AddressNotFoundException{
	
		addressService.deleteAddressById(id);
	
		return new ResponseEntity("deleted successfully:", HttpStatus.ACCEPTED);
}
	@PutMapping("/update-Address/{id}")
	
    public ResponseEntity updateAddress(@PathVariable Long id, @RequestBody Address addressRequest) throws AddressNotFoundException {
		addressService.updateAddressById(id,addressRequest);
		return new ResponseEntity("Updated ", HttpStatus.OK);
	}
   

   /*
    @GetMapping("/customer/{userId}/address")
    public ResponseEntity getAddress() {
        List<Address> address = addressService.getAllAddress();
        return new ResponseEntity<>(address, HttpStatus.OK);
    }
    
    @PutMapping("/customer/{userId}/address")
    public ResponseEntity updateAddress(@PathVariable(value = "userId") Long userId,
                                        @RequestBody Address addressRequest) throws AddressNotFoundException {
        addressService.updateAddress(userId, addressRequest);
        return new ResponseEntity<>(addressRequest, HttpStatus.OK);
    }

   

    @DeleteMapping("/customer/{userId}/address/{addressId}")
    public ResponseEntity deleteAddress(@PathVariable(value = "userId") Long userId,
                                        @PathVariable(value = "addressId") Long addressId) throws AddressNotFoundException{
        addressService.deleteAddress(userId,addressId);
        return new ResponseEntity(HttpStatus.OK);
    }*/
}
	
	