package com.cg.cars.services.impl;

import java.util.List;
import java.util.Optional;

import com.cg.cars.entities.Car;
import com.cg.cars.entities.Card;
import com.cg.cars.exceptions.CarNotFoundException;
import com.cg.cars.services.CarService;
import com.cg.cars.model.CarDTO;
import com.cg.cars.repository.CarRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.cars.util.CarUtils;

@Service
public class CarServiceImpl implements CarService {
	static final Logger LOGGER = LoggerFactory.getLogger(CarServiceImpl.class);

	@Autowired
	private CarRepository carRepository;

	public CarDTO addCar(Car car) {

		LOGGER.info("addCar() service is initiated");
		Car carEntity = carRepository.save(car);
		LOGGER.info("addCar() service has executed");
		return CarUtils.convertToCarDto(carEntity);
	}

	public CarDTO getCarById(Long id) throws CarNotFoundException {
		LOGGER.info("getCarById() service is initiated");
		Optional<Car> existCar = carRepository.findById(id);
		if (existCar.isPresent()) {
			Car car = existCar.get();

			LOGGER.info("getCarById() service has executed");
			return CarUtils.convertToCarDto(car);
		} else {
			throw new CarNotFoundException("Car with the id not found");
		}

	}

	public List<CarDTO> getAllCars() {
		LOGGER.info("getAllCar() service is initiated");
		List<Car> carList = carRepository.findAll();

		LOGGER.info("getAllCar() service has executed");
		return CarUtils.convertToCarDtoList(carList);
	}

	public List<CarDTO> getCarsByBrand(String brand) {
		LOGGER.info("getCarByBrand() service is initiated");
		List<Car> carexist = carRepository.findByBrand(brand);

		LOGGER.info("getCarByBrand() service has executed");
		return CarUtils.convertToCarDtoList(carexist);

	}

	public List<CarDTO> getCarsByLocation(String registrationState) {
		LOGGER.info("getCarByLocation() service is initiated");
		List<Car> carexist = carRepository.findByLocation(registrationState);

		LOGGER.info("getCarByLocation() service has executed");
		return CarUtils.convertToCarDtoList(carexist);

	}

	public List<CarDTO> getCarsByModel(String model) {
		LOGGER.info("getCarByModel() service is initiated");
		List<Car> carexist = carRepository.findByModel(model);

		LOGGER.info("getCarByModel() service has executed");
		return CarUtils.convertToCarDtoList(carexist);
	}

	public CarDTO deleteCarById(Long id) throws CarNotFoundException {
		LOGGER.info("deleteCar() service is initiated");
		Car carexist = carRepository.findById(id).orElse(null);
		if (carexist == null)
			throw new CarNotFoundException("Car with id not present");
		else
			carRepository.delete(carexist);

		LOGGER.info("deleteCar() service has executed");
		return CarUtils.convertToCarDto(carexist);
	}

	public Car updateCarById(Long id, Car carRequest) throws CarNotFoundException {
		LOGGER.info("updateCar() service is initiated");
		return carRepository.findById(id).map(car -> {
			car.setCarId(carRequest.getCarId());
			car.setBrand(carRequest.getBrand());
			car.setModel(carRequest.getModel());
			car.setVariant(carRequest.getVariant());
			car.setRegistrationYear(carRequest.getRegistrationYear());
			car.setRegistrationState(carRequest.getRegistrationState());

			LOGGER.info("updateCar() service has executed");

			return carRepository.save(car);
		}).orElseThrow(() -> new CarNotFoundException("Car with id not present"));

	}
}
