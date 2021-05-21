package com.cg.cars.util;

import com.cg.cars.model.CarDTO;
import com.cg.cars.entities.Car;
import java.util.List;
import java.time.LocalDate;
import java.util.ArrayList;

public class CarUtils {
	private CarUtils() {
	}
	//converting into screen class
	public static List<CarDTO> convertToCarDtoList(List<Car> list){
		List<CarDTO> dtolist=new ArrayList<CarDTO>();
		for(Car car :list)
			dtolist.add(convertToCarDto(car));
		return dtolist;
}
	
	public static Car convertToCar(CarDTO dto) {
		Car car= new Car();
		car.setCarId(dto.getCarId());
		car.setBrand(dto.getBrand());
		car.setModel(dto.getModel());
		car.setVariant(dto.getVariant());
		car.setRegistrationState(dto.getRegistrationState());
		car.setRegistrationYear(dto.getRegistrationYear());
		
	return car;	
	}
	
	public static CarDTO convertToCarDto(Car car ) {
		CarDTO dto=new CarDTO();
		dto.setCarId(car.getCarId());
		dto.setBrand(car.getBrand());
		dto.setModel(car.getModel());
		dto.setVariant(car.getVariant());
		dto.setRegistrationState(car.getRegistrationState());
		dto.setRegistrationYear(car.getRegistrationYear());
		
	return dto;	
	}
}
