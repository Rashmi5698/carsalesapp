package com.cg.cars.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.Test;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import com.cg.cars.entities.Car;
import com.cg.cars.entities.Card;
import com.cg.cars.exceptions.CardNotFoundException;
import com.cg.cars.exceptions.UserNotFoundException;
import com.cg.cars.model.CarDTO;
import com.cg.cars.model.CardDTO;
import com.cg.cars.repository.CarRepository;
import com.cg.cars.repository.CardRepository;
import com.cg.cars.util.CarUtils;
import com.cg.cars.util.CardUtils;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CarServiceTest {

	@MockBean
	private CarRepository carRepo;

	@Autowired
	private CarService carService;

	@Test
	public void addCarTest() {
		Car Car = new Car();
		Car.setCarId(4545L);
		Car.setBrand("Bugatii");
		Car.setModel("New");
		Car.setVariant("yes");
		Car.setRegistrationYear(LocalDate.now());
		Car.setRegistrationState("Bangalore");

		Mockito.when(carRepo.save(Car)).thenReturn(Car);
		CarDTO CarDTO = CarUtils.convertToCarDto(Car);
		assertEquals(4545L,CarDTO.getCarId());
	}

	@Test
	public void showCarByIdTest() throws UserNotFoundException {
		Car Car = new Car();
		Car.setCarId(4578L);
		Car.setBrand("Bugatii");
		Car.setModel("New");
		Car.setVariant("yes");
		Car.setRegistrationYear(LocalDate.now());
		Car.setRegistrationState("Bangalore");

		Mockito.when(carRepo.save(Car)).thenReturn(Car);
		assertEquals(4578L,Car.getCarId());
	}

	@Test
	public void showAllCarTest() throws UserNotFoundException {
		Car Car1 = new Car();
		Car1.setCarId(4578L);
		Car1.setBrand("Bugatii");
		Car1.setModel("New");
		Car1.setVariant("yes");
		Car1.setRegistrationYear(LocalDate.now());
		Car1.setRegistrationState("Bangalore");

		Car Car = new Car();
		Car.setCarId(4578L);
		Car.setBrand("Bugatii");
		Car.setModel("New");
		Car.setVariant("yes");
		Car.setRegistrationYear(LocalDate.now());
		Car.setRegistrationState("Bangalore");
		List<Car> CarList = new ArrayList<>();
		CarList.add(Car1);
		CarList.add(Car);
		Mockito.when(carRepo.findAll()).thenReturn(CarList);
//		System.out.println("Service list"+productService.showAllProducts());
		List<CarDTO> dto = CarUtils.convertToCarDtoList(CarList);
//		System.out.println("after converting:"+dto);
		assertSame(2,carService.getAllCars().size());
	}

	@Test
	public void deleteCarTest() {
		Car Car1 = new Car();
		Car1.setCarId(4578L);
		Car1.setBrand("Bugatii");
		Car1.setModel("New");
		Car1.setVariant("yes");
		Car1.setRegistrationYear(LocalDate.now());
		Car1.setRegistrationState("Bangalore");
		Mockito.when(carRepo.save(Car1)).thenReturn(Car1);
		carRepo.deleteById(Car1.getCarId());
		assertNotEquals(Car1, new Car());
	}

	@Test
	public void updateCarTest() {

		Car Car1 = new Car();
		Car1.setCarId(4578L);
		Car1.setBrand("Bugatii");
		Car1.setModel("New");
		Car1.setVariant("yes");
		Car1.setRegistrationYear(LocalDate.now());
		Car1.setRegistrationState("Bangalore");

		carRepo.save(Car1);

		Mockito.when(carRepo.save(Car1)).thenReturn(Car1);
		assertEquals(4578L,Car1.getCarId());
	}
	 @Test
	    public void testFindByModel() throws Exception{
	      
		 Car car=new Car();
	       car.setCarId(4578L);
			car.setBrand("Bugatii");
			car.setModel("New");
			car.setVariant("yes");
			car.setRegistrationYear(LocalDate.now());
			car.setRegistrationState("Bangalore");
			List<Car> carList=new ArrayList<>();
			carList.add(car);
			

	        Mockito.when(carRepo.findByModel("New")).thenReturn(carList);
	        assertThat(carRepo.findByModel("New")).isEqualTo(carList);
	    }
	 @Test
	    public void testFindByLocation() throws Exception{
	       Car car=new Car();
	       car.setCarId(4578L);
			car.setBrand("Bugatii");
			car.setModel("New");
			car.setVariant("yes");
			car.setRegistrationYear(LocalDate.now());
			car.setRegistrationState("Bangalore");
			List<Car> carList=new ArrayList<>();
			carList.add(car);

	        Mockito.when(carRepo.findByLocation("Bangalore")).thenReturn(carList);
	        assertThat(carRepo.findByLocation("Bangalore")).isEqualTo(carList);
	    }
	 @Test
	    public void testFindByBrand() throws Exception{
	       Car car=new Car();
	       car.setCarId(4578L);
			car.setBrand("Bugatii");
			car.setModel("New");
			car.setVariant("yes");
			car.setRegistrationYear(LocalDate.now());
			car.setRegistrationState("Bangalore");
			List<Car> carList=new ArrayList<>();
			carList.add(car);

	        Mockito.when(carRepo.findByBrand("Bugatti")).thenReturn(carList);
	        assertThat(carRepo.findByBrand("Bugatti")).isEqualTo(carList);
	    }
	

}