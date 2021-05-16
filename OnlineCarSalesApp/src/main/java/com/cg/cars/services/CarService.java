package com.cg.cars.services;

import java.util.List;

import com.cg.cars.entities.Car;

import com.cg.cars.model.CarDTO;



public interface CarService {
	
	public CarDTO addCar(Car car);
	
	public CarDTO getCarById(long id);
	
	public List<CarDTO> getAllCars();
	
	public void deleteCar(CarDTO cardto); 
	
	public void updateCar(CarDTO cardto);
	
	//public Car removeCar(long id);
	
	//public Car updateCar(long id, Car car);

	public List<CarDTO> getCarsByLocation(String registrationState);
	
	public List<CarDTO> getCarsByModel(String model);
	
	public List<CarDTO> getCarsByBrand(String brand);

	


	
}