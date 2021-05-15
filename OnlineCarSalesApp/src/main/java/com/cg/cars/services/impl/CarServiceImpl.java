package com.cg.cars.services.impl;

import java.util.List;
import java.util.Optional;

import com.cg.cars.entities.Car;
import com.cg.cars.services.CarService;
import com.cg.cars.model.CarDTO;


import com.cg.cars.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.cars.util.CarUtils;


@Service
public class CarServiceImpl implements CarService{
	
	@Autowired
	private CarRepository carRepository;
	
	
public CarDTO addCar(Car car){
	Car carEntity=carRepository.save(car);
	return CarUtils.convertToCarDto(carEntity);
}


public void deleteCar(CarDTO cardto) {
	
	carRepository.delete(CarUtils.convertToCar(cardto));
	
}
	
public void updateCar(CarDTO cardto) {
	
	carRepository.save(CarUtils.convertToCar(cardto));
			
	
}

public CarDTO getCarById(long id) {
	Optional<Car> existCar=carRepository.findById(id);
	if(existCar.isPresent()) {
		Car car=existCar.get();
	return CarUtils.convertToCarDto(car);
}
	else {
		return null;
	}
	
}


public List<CarDTO> getAllCars(){
		List<Car> carList=carRepository.findAll();
		return CarUtils.convertToCarDtoList(carList);
		}
}





