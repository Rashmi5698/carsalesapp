package com.cg.cars.util;

import com.cg.cars.model.CarDTO;
import com.cg.cars.entities.Car;
import java.util.List;
import java.util.ArrayList;

public class CarUtils {
	private CarUtils() {
	}

	public static List<CarDTO> convertToCarDtoList(List<Car> list) {
		List<CarDTO> dtolist = new ArrayList<>();
		for (Car car : list)
			dtolist.add(convertToCarDto(car));
		return dtolist;
	}

	

	public static CarDTO convertToCarDto(Car car) {
		CarDTO dto = new CarDTO();
		dto.setCarId(car.getCarId());
		dto.setBrand(car.getBrand());
		dto.setModel(car.getModel());
		dto.setVariant(car.getVariant());
		dto.setRegistrationState(car.getRegistrationState());
		dto.setRegistrationYear(car.getRegistrationYear());

		return dto;
	}
}
