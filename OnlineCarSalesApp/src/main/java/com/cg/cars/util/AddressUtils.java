package com.cg.cars.util;

import com.cg.cars.model.AddressDTO;
import com.cg.cars.entities.Address;
import java.util.List;
import java.util.ArrayList;

public class AddressUtils {
	private AddressUtils() {
	}

	public static List<AddressDTO> convertToAddressDtoList(List<Address> list) {
		List<AddressDTO> dtolist = new ArrayList<AddressDTO>();
		for (Address address : list)
			dtolist.add(convertToAddressDto(address));
		return dtolist;
	}

	public static AddressDTO convertToAddressDto(Address address) {
		AddressDTO dto = new AddressDTO();
		dto.setAddressId(address.getAddressId());
		dto.setDoorNo(address.getDoorNo());
		dto.setStreet(address.getStreet());
		dto.setArea(address.getArea());
		dto.setCity(address.getCity());
		dto.setState(address.getState());
		dto.setPincode(address.getPincode());
		dto.setCustomers(address.getCustomers());

		return dto;
	}
}
