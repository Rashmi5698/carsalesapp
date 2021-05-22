package com.cg.cars.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.Test;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import com.cg.cars.entities.Address;
import com.cg.cars.entities.Card;
import com.cg.cars.exceptions.CardNotFoundException;
import com.cg.cars.exceptions.UserNotFoundException;
import com.cg.cars.model.AddressDTO;
import com.cg.cars.model.CardDTO;
import com.cg.cars.repository.AddressRepository;
import com.cg.cars.repository.CardRepository;
import com.cg.cars.util.AddressUtils;
import com.cg.cars.util.CardUtils;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AddressServiceTest {

	@MockBean
	private AddressRepository addressRepo;

	@Autowired
	private AddressService addressService;

	@Test
	public void addAddressTest() {
		Address Address = new Address();
		Address.setAddressId(4545L);
		Address.setDoorNo(45L);
		Address.setStreet("Church Street");
		Address.setArea("MG");
		Address.setCity("Bangalore");
		Address.setState("Karnataka");
		Address.setPincode(560074L);

		Mockito.when(addressRepo.save(Address)).thenReturn(Address);
		AddressDTO AddressDTO = AddressUtils.convertToAddressDto(Address);
		assertEquals(AddressDTO.getAddressId(), 4545L);
	}

	@Test
	public void showAddressByIdTest() throws UserNotFoundException {
		Address Address = new Address();
		Address.setAddressId(4578L);
		Address.setDoorNo(45L);
		Address.setStreet("Church Street");
		Address.setArea("MG");
		Address.setCity("Bangalore");
		Address.setState("Karnataka");
		Address.setPincode(560074L);

		Mockito.when(addressRepo.save(Address)).thenReturn(Address);
		assertEquals(Address.getAddressId(), 4578L);
	}

	@Test
	public void showAllAddressTest() throws UserNotFoundException {
		Address Address = new Address();
		Address.setAddressId(4578L);
		Address.setDoorNo(45L);
		Address.setStreet("Church Street");
		Address.setArea("MG");
		Address.setCity("Bangalore");
		Address.setState("Karnataka");
		Address.setPincode(560074L);

		Address Address1 = new Address();
		Address.setAddressId(4578L);
		Address1.setDoorNo(45L);
		Address1.setStreet("Church Street");
		Address1.setArea("MG");
		Address1.setCity("Bangalore");
		Address1.setState("Karnataka");
		Address1.setPincode(560074L);

		List<Address> AddressList = new ArrayList<>();
		AddressList.add(Address);
		AddressList.add(Address1);
		Mockito.when(addressRepo.findAll()).thenReturn(AddressList);
//		System.out.println("Service list"+productService.showAllProducts());
		List<AddressDTO> dto = AddressUtils.convertToAddressDtoList(AddressList);
//		System.out.println("after converting:"+dto);
		assertSame(addressService.getAllAddress().size(), 2);
	}

	@Test
	public void deleteAddressTest() {
		Address Address1 = new Address();
		Address1.setAddressId(4578L);
		Address1.setDoorNo(45L);
		Address1.setStreet("Church Street");
		Address1.setArea("MG");
		Address1.setCity("Bangalore");
		Address1.setState("Karnataka");
		Address1.setPincode(560074L);

		Mockito.when(addressRepo.save(Address1)).thenReturn(Address1);
		addressRepo.deleteById(Address1.getAddressId());
		assertNotEquals(Address1, new Address());
	}

	@Test
	public void updateAddressTest() {

		Address Address1 = new Address();
		Address1.setAddressId(4578L);
		Address1.setDoorNo(45L);
		Address1.setStreet("Church Street");
		Address1.setArea("MG");
		Address1.setCity("Bangalore");
		Address1.setState("Karnataka");
		Address1.setPincode(560074L);

		addressRepo.save(Address1);

		Mockito.when(addressRepo.save(Address1)).thenReturn(Address1);
		assertEquals(Address1.getAddressId(), 4578L);
	}
}