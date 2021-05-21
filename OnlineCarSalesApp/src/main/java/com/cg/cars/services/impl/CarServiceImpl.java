package com.cg.cars.services.impl;

import java.util.List;
import java.util.Optional;


import com.cg.cars.entities.Car;
import com.cg.cars.exceptions.CarNotFoundException;
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

public CarDTO getCarById(Long id) throws CarNotFoundException {
	Optional<Car> existCar=carRepository.findById(id);
	if(existCar.isPresent()) {
		Car car=existCar.get();
	return CarUtils.convertToCarDto(car);
}
	else {
		throw new CarNotFoundException("Car with the id not found");
	}
	
}


public List<CarDTO> getAllCars(){
		List<Car> carList=carRepository.findAll();
		return CarUtils.convertToCarDtoList(carList);
		}

public List<CarDTO> getCarsByBrand(String brand){
	        List<Car> carexist=carRepository.findByBrand(brand);
	        return CarUtils.convertToCarDtoList(carexist);
	        
	    }
public List<CarDTO> getCarsByLocation(String registrationState){
    List<Car> carexist=carRepository.findByLocation(registrationState);
    return CarUtils.convertToCarDtoList(carexist);
    
}
public List<CarDTO> getCarsByModel(String model){
    List<Car> carexist=carRepository.findByModel(model);
    return CarUtils.convertToCarDtoList(carexist);
}
/*
public List<CarDTO> getCarsByModel(String model) throws ModelNotFoundException{
    List<Car> carexist=carRepository.findByModel(model);
    if(carexist.isPresent()) {
    	Car car=carexist.get();
    return CarUtils.convertToCarDto(car);
    }
    else {
    	throw new ModelNotFoundException("Car with the model not found");
    }

}
public List<CarDTO> getCarsByBrand(String brand) throws BrandNotFoundException{
    List<Car> carexist=carRepository.findByBrand(brand);
    if(carexist.isPresent()) {
    	Car car=carexist.get();
    return CarUtils.convertToCarDtoList(car);
    }
    else {
    	throw new BrandNotFoundException("Car with the model not found");
    }

}
public List<CarDTO> getCarsByLocation(String registrationState) throws LocationNotFoundException{
    List<Car> carexist=carRepository.findByLocation(registrationState);
    if(carexist.isPresent()) {		
    	Car car=carexist.get();
    return CarUtils.convertToCarDto(car);
    }
    else {
    	throw new LocationNotFoundException("Car with the model not found");
    }

}*/
public CarDTO deleteCarById(Long id)throws CarNotFoundException {
	Car carexist=carRepository.findById(id).orElse(null);
	if(carexist==null)
		throw new CarNotFoundException("Car with id not present");
	else
		carRepository.delete(carexist);
	return CarUtils.convertToCarDto(carexist);
	}



public Car updateCarById(Long id, Car carRequest) throws CarNotFoundException{
    return carRepository.findById(id).map( car-> {
    	car.setCarId(carRequest.getCarId());
    	car.setBrand(carRequest.getBrand());
    	car.setModel(carRequest.getModel());
    	car.setVariant(carRequest.getVariant());
    	car.setRegistrationYear(carRequest.getRegistrationYear());
    	car.setRegistrationState(carRequest.getRegistrationState());
    	
    return carRepository.save(car);
    }).orElseThrow(()-> new CarNotFoundException("Car with id not present"));
    
}
}
