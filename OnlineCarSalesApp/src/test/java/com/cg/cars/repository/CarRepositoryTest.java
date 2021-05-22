package com.cg.cars.repository;

import org.junit.runner.RunWith;
import com.cg.cars.entities.Car;
import com.cg.cars.entities.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CarRepositoryTest {

	@Autowired
	private CarRepository carRepository;

	@Autowired
	private TestEntityManager testEntityManager;

	@Test
	public void testNewCar() throws Exception {
		Car car = getCar();
		Car saveInDb = testEntityManager.persist(car);
		Car getFromInDb = carRepository.findById(saveInDb.getCarId()).get();
		assertThat(getFromInDb).isEqualTo(saveInDb);
	}

	@Test
	public void testGetCarById() throws Exception {
		Car car = new Car();
		car.setBrand("Bugatii");
		car.setModel("New");
		car.setVariant("yes");
		car.setRegistrationYear(LocalDate.now());
		car.setRegistrationState("Bangalore");

		// Insert Data into in memory database
		Car saveInDb = testEntityManager.persist(car);
		// Get Data from DB
		Car getInDb = carRepository.findById(car.getCarId()).get();
		assertThat(getInDb).isEqualTo(saveInDb);
	}

	@Test
	public void testGetAllCars() throws Exception {
		Car car1 = new Car();

		car1.setBrand("Bugatii");
		car1.setModel("New");
		car1.setVariant("yes");
		car1.setRegistrationYear(LocalDate.now());
		car1.setRegistrationState("Bangalore");

		Car car2 = new Car();
		car2.setBrand("Bugatii");
		car2.setModel("Old");
		car2.setVariant("no");
		car2.setRegistrationYear(LocalDate.now());
		car2.setRegistrationState("Bangalore");

		// Save into in memory database
		testEntityManager.persist(car1);
		testEntityManager.persist(car2);

		// Retrieve all tickets
		List<Car> CarList = (List<Car>) carRepository.findAll();

		Assert.assertEquals(2, CarList.size());
	}

	@Test
	public void testDeleteCarById() throws Exception {
		Car car1 = new Car();
		car1.setBrand("Bugatii");
		car1.setModel("New");
		car1.setVariant("yes");
		car1.setRegistrationYear(LocalDate.now());
		car1.setRegistrationState("Bangalore");

		Car car2 = new Car();
		car1.setBrand("Bugatii");
		car1.setModel("New");
		car1.setVariant("yes");
		car1.setRegistrationYear(LocalDate.now());
		car1.setRegistrationState("Bangalore");

		Car car = testEntityManager.persist(car1);
		testEntityManager.persist(car2);

		testEntityManager.remove(car);

		List<Car> Cars = (List<Car>) carRepository.findAll();
		Assert.assertEquals(Cars.size(), 1);

	}

	@Test
	public void testUpdateCarById() {
		Car car = new Car();
		car.setBrand("Bugatii");
		car.setModel("New");
		car.setVariant("yes");
		car.setRegistrationYear(LocalDate.now());
		car.setRegistrationState("Bangalore");
		Car saveInDb = testEntityManager.persist(car);

		Car getFromDb = carRepository.findById(car.getCarId()).get();

		assertThat(getFromDb).isEqualTo(saveInDb);

	}

	private Car getCar() {
		Car car = new Car();
		car.setBrand("Bugatii");
		car.setModel("New");
		car.setVariant("yes");
		car.setRegistrationYear(LocalDate.now());
		car.setRegistrationState("Bangalore");

		return car;

	}
}
