package com.cg.cars.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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


@RestController
@RequestMapping("/api/cars")
public class CarController {
	static final Logger LOGGER = LoggerFactory.getLogger(CarController.class);

	@Autowired
	private CarService carService;

	/************************************************************************************
	 * Method: addCar 
	 * Description: It is used to add Car into Cars table
	 * @param Car: Car's reference variable.
	 * @returns Car: It returns Car with details
	 * @PostMapping: It is used to handle the HTTP POST requests matched with given URI expression.
	 * @RequestBody: It used to bind the HTTP request/response body with a domain object in method parameter or return type
	 ************************************************************************************/
	@PostMapping("/add-car")
	public ResponseEntity<Object> insertCar(@RequestBody Car car) {
		LOGGER.info("add-Car URL is opened");
		LOGGER.info("addCar() is initiated");
		CarDTO carDTO = carService.addCar(car);
		ResponseEntity<Object> carResponse = new ResponseEntity<>(carDTO, HttpStatus.ACCEPTED);
		LOGGER.info("addCar() has executed");
		return carResponse;
	}

	/************************************************************************************
	 * Method: getCarById 
	 * Description: It is used to view Car by id from Cars table
	 * @param Car: Long id
	 * @returns Car: It returns Car with details
	 * @GetMapping: It is used to handle the HTTP GET requests matched with given URI expression.
	 * @RequestBody: It used to bind the HTTP request/response body with a domain object in method parameter or return type.
	 ************************************************************************************/
	@GetMapping("/view-car/{id}")
	public ResponseEntity<Object> getCarById(@PathVariable Long id) throws CarNotFoundException {
		LOGGER.info("view-Car URL is opened");
		LOGGER.info("viewCar() is initiated");
		CarDTO carDTO = carService.getCarById(id);
		LOGGER.info("viewCar() has executed");
		return new ResponseEntity<>(carDTO, HttpStatus.OK);
	}

	/************************************************************************************
	 * Method: getAllCars 
	 * Description: It is used to view all Cars in Cars table
	 * @returns Car: It returns Car with details
	 * @GetMapping: It is used to handle the HTTP GET requests matched with given URI expression.
	 * @RequestBody: It used to bind the HTTP request/response body with a domain object in method parameter or return type.
	 ************************************************************************************/

	@GetMapping("/view-all-cars")
	public List<CarDTO> viewAllCars() {
		LOGGER.info("view-all-Car URL is opened");
		LOGGER.info("viewAllCar() is initiated");
		LOGGER.info("viewAllCar() has executed");
		return carService.getAllCars();
	}
	/************************************************************************************
	 * Method: getAllCarBrand
	 * Description: It is used to view all CarBrands in Cars table
	 * @returns Car: It returns CarBrand with details
	 * @GetMapping: It is used to handle the HTTP GET requests matched with given URI expression.
	 * @RequestBody: It used to bind the HTTP request/response body with a domain object in method parameter or return type.
	 ************************************************************************************/
	@GetMapping("/view-car-byBrand/{brand:.+}")
	public ResponseEntity<Object> findCarByBrand(@PathVariable String brand) {
		LOGGER.info("view-all-CarByBrand URL is opened");
		LOGGER.info("viewAllCarByBrand() is initiated");
		List<CarDTO> carDTO = carService.getCarsByBrand(brand);
		LOGGER.info("viewAllCarByBrand() has executed");
		return new ResponseEntity<>(carDTO, HttpStatus.OK);
	}
	/************************************************************************************
	 * Method: getAllCarModels
	 * Description: It is used to view all CarModels in Cars table
	 * @returns Car: It returns CarModel with details
	 * @GetMapping: It is used to handle the HTTP GET requests matched with given URI expression.
	 * @RequestBody: It used to bind the HTTP request/response body with a domain object in method parameter or return type.
	 ************************************************************************************/

	@GetMapping("/view-car-byModel/{model:.+}")
	public ResponseEntity<Object> findCarByModel(@PathVariable String model) {
		LOGGER.info("view-all-CarByModel URL is opened");
		LOGGER.info("viewAllCarByModel() is initiated");
		List<CarDTO> carDTO = carService.getCarsByModel(model);
		LOGGER.info("viewAllCarByModel() has executed");
		return new ResponseEntity<>(carDTO, HttpStatus.OK);
	}
	/************************************************************************************
	 * Method: getAllCarLocation
	 * Description: It is used to view all CarLocation in Cars table
	 * @returns Car: It returns CarLocation with details
	 * @GetMapping: It is used to handle the HTTP GET requests matched with given URI expression.
	 * @RequestBody: It used to bind the HTTP request/response body with a domain object in method parameter or return type.
	 ************************************************************************************/
	@GetMapping("/view-car-byLocation/{registrationState:.+}")
	public ResponseEntity<Object> findCarByLocation(@PathVariable String registrationState) {
		LOGGER.info("view-all-CarByLocation URL is opened");
		LOGGER.info("viewAllCarByLocation() is initiated");
		List<CarDTO> carDTO = carService.getCarsByLocation(registrationState);
		LOGGER.info("viewAllCarByLocation() has executed");
		return new ResponseEntity<>(carDTO, HttpStatus.OK);
	}

	/************************************************************************************
	 * Method: DeleteCar 
	 * Description: It is used to remove Car from Cars table
	 * @param Car: Long id
	 * @returns Car It returns Car with details
	 * @DeleteMapping: It is used to handle the HTTP DELETE requests matched with given URI expression.
	 * @RequestBody: It used to bind the HTTP request/response body with a domain object in method parameter or return type.
	 ************************************************************************************/

	@DeleteMapping("/delete-car/{id}")
	public ResponseEntity<Object> deleteCarById(@PathVariable Long id) throws CarNotFoundException {
		LOGGER.info("delete-Car URL is opened");
		LOGGER.info("deleteCar() is initiated");
		carService.deleteCarById(id);
		LOGGER.info("deleteCar() has executed");
		return new ResponseEntity<>("deleted successfully:", HttpStatus.ACCEPTED);
	}

	/************************************************************************************
	 * Method: updateCar 
	 * Description: It is used to update Car into Car table
	 * @param Car: Car's reference variable.
	 * @returns Car: It returns Car with details
	 * @PutMapping: It is used to handle the HTTP PUT requests matched with given URI expression.
	 * @RequestBody: It used to bind the HTTP request/response body with a domain object in method parameter or return type.
	 ************************************************************************************/
	@PutMapping("/update-car/{id}")
	public ResponseEntity<Object> updateCar(@PathVariable Long id, @RequestBody Car carRequest) throws CarNotFoundException {
		LOGGER.info("update-Car URL is opened");
		LOGGER.info("updateCar() is initiated");
		carService.updateCarById(id, carRequest);
		LOGGER.info("updateCar() has executed");
		return new ResponseEntity<>("Updated ", HttpStatus.OK);
	}

}
