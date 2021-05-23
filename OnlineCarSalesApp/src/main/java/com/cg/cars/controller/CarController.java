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
import com.cg.cars.model.CarDTO;
import com.cg.cars.entities.Car;
import com.cg.cars.exceptions.CarNotFoundException;



//@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/api/cars")
public class CarController {
	
	@Autowired
	private CarService carService;
	@PostMapping("/add-car")
	public ResponseEntity<Object> insertCar(@RequestBody Car car)
	{
		//CarDTO carDTO = null;
		//ResponseEntity<Object> carResponse = null;
		 CarDTO carDTO =carService.addCar(car);
		 ResponseEntity<Object> carResponse = new ResponseEntity<Object>(carDTO, HttpStatus.ACCEPTED);
		return carResponse;
	}
	@GetMapping("/view-car/{id}")
	public ResponseEntity getCarById(@PathVariable Long id) throws CarNotFoundException {
	CarDTO carDTO = carService.getCarById(id);	
		return new ResponseEntity(carDTO, HttpStatus.OK);
	}
	
	
	@GetMapping("/view-all-cars")
	public List<CarDTO> viewAllCars() {
		
		return carService.getAllCars();
	}
	

	  @GetMapping("/view-car-byBrand/{brand:.+}")
	    public ResponseEntity findCarByBrand(@PathVariable String brand) {
	    		//throws BrandNotFoundException{
		  List<CarDTO> carDTO = carService.getCarsByBrand(brand);
	        return new ResponseEntity(carDTO, HttpStatus.OK);
	    }
	  @GetMapping("/view-car-byModel/{model:.+}")
	    public ResponseEntity findCarByModel(@PathVariable String model) {
	    		//throws ModelNotFoundException{
		  List<CarDTO> carDTO = carService.getCarsByModel(model);
	        return new ResponseEntity(carDTO, HttpStatus.OK);
	    }
	  @GetMapping("/view-car-byLocation/{registrationState:.+}")
	    public ResponseEntity findCarByLocation(@PathVariable String registrationState) {
	    		//throws LocationNotFoundException{
		  List<CarDTO> carDTO = carService.getCarsByLocation(registrationState);
	        return new ResponseEntity(carDTO, HttpStatus.OK);
	    }
	  
	  @DeleteMapping("/delete-car/{id}")
		public ResponseEntity<Object> deleteCarById(@PathVariable Long id)throws CarNotFoundException{
		
			carService.deleteCarById(id);
		
			return new ResponseEntity("deleted successfully:", HttpStatus.ACCEPTED);
	}
		@PutMapping("/update-car/{id}")
	    public ResponseEntity updateCar(@PathVariable Long id, @RequestBody Car carRequest) throws CarNotFoundException {
			carService.updateCarById(id,carRequest);
			return new ResponseEntity("Updated ", HttpStatus.OK);
		}

	 
}
