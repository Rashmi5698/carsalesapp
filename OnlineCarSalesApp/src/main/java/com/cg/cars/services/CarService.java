package com.cg.cars.services;

import java.util.List;
import com.cg.cars.entities.Car;
import com.cg.cars.exceptions.CarNotFoundException;
import com.cg.cars.model.CarDTO;

public interface CarService {

	public CarDTO addCar(Car car);

	public CarDTO getCarById(Long id) throws CarNotFoundException;

	public List<CarDTO> getAllCars();

	public CarDTO deleteCarById(Long id) throws CarNotFoundException;

	public Car updateCarById(Long id, Car CarRequest) throws CarNotFoundException;

	public List<CarDTO> getCarsByLocation(String registrationState);
	

	public List<CarDTO> getCarsByModel(String model);

	public List<CarDTO> getCarsByBrand(String brand);
	

}