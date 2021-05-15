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
import com.cg.cars.services.CarService;
import com.cg.cars.services.CarService;
import com.cg.cars.model.CarDTO;
import com.cg.cars.model.CarDTO;
import com.cg.cars.entities.Car;
import com.cg.cars.entities.Car;

//@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/api/cars")
public class CarController {
	
	@Autowired
	private CarService carService;
	@PostMapping("/add-car")
	public ResponseEntity<Object> insertCar(@RequestBody Car car)
	{
		CarDTO carDTO = null;
		ResponseEntity<Object> carResponse = null;
		carDTO =carService.addCar(car);
		carResponse = new ResponseEntity<Object>(carDTO, HttpStatus.ACCEPTED);
		return carResponse;
	}
	@GetMapping("/view-car/{id}")
	public ResponseEntity getCarById(@PathVariable long id) {
	
		CarDTO carDTO = carService.getCarById(id);
		
		return new ResponseEntity(carDTO, HttpStatus.OK);
	}
	
	
	@GetMapping("/view-all-cars")
	public List<CarDTO> viewAllCars() {
		
		return carService.getAllCars();
	}
	
	@DeleteMapping("/delete-car")
	public ResponseEntity deleteCar(@RequestBody CarDTO cardto){
	 carService.deleteCar(cardto);
	return new ResponseEntity("deleted successfully:",HttpStatus.OK);
		
		
	}
	
	@PutMapping("/update-car")
	public ResponseEntity updateCar(@RequestBody CarDTO cardto) {
		carService.updateCar(cardto);
		return new ResponseEntity("Updated ", HttpStatus.OK);
		

	}
	

}
