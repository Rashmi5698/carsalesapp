package com.cg.cars.repository;

import org.junit.runner.RunWith;
import com.cg.cars.entities.Customer;
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
public class CustomerRepositoryTest {

	@Autowired
	private CustomerRepository CustomerRepository;

	@Autowired
	private TestEntityManager testEntityManager;

	@Test
	public void testNewCustomer() throws Exception {
		Customer customer = getCustomer();
		Customer saveInDb = testEntityManager.persist(customer);
		Customer getFromInDb = CustomerRepository.findById(saveInDb.getUserId()).get();
		assertThat(getFromInDb).isEqualTo(saveInDb);
	}

	@Test
	public void testGetCustomerById() throws Exception {
		Customer customer = new Customer();

		customer.setUserId(45L);
		customer.setName("bhumi");
		customer.setEmail("bhumi@gmail.com");
		customer.setContactNo("45687545");
		customer.setDob(LocalDate.now());
		// Insert Data into in memory database
		Customer saveInDb = testEntityManager.persist(customer);
		// Get Data from DB
		Customer getInDb = CustomerRepository.findById(customer.getUserId()).get();
		assertThat(getInDb).isEqualTo(saveInDb);
	}

	@Test
	public void testGetAllCustomers() throws Exception {
		Customer customer1 = new Customer();

		customer1.setUserId(45L);
		customer1.setName("bhumi");
		customer1.setEmail("bhumi@gmail.com");
		customer1.setContactNo("45687545");
		customer1.setDob(LocalDate.now());

		Customer customer2 = new Customer();

		customer2.setUserId(46L);
		customer2.setName("bhumi");
		customer2.setEmail("bhumi@gmail.com");
		customer2.setContactNo("45687545");
		customer2.setDob(LocalDate.now());
		// Save into in memory database
		testEntityManager.persist(customer1);
		testEntityManager.persist(customer2);

		// Retrieve all tickets
		List<Customer> customerList = (List<Customer>) CustomerRepository.findAll();

		Assert.assertEquals(2, customerList.size());
	}

	@Test
	public void testDeleteCustomerById() throws Exception {
		Customer customer1 = new Customer();

		customer1.setUserId(45L);
		customer1.setName("bhumi");
		customer1.setEmail("bhumi@gmail.com");
		customer1.setContactNo("45687545");
		customer1.setDob(LocalDate.now());

		Customer customer2 = new Customer();

		customer2.setUserId(46L);
		customer2.setName("bhumi");
		customer2.setEmail("bhumi@gmail.com");
		customer2.setContactNo("45687545");
		customer2.setDob(LocalDate.now());

		Customer customer = testEntityManager.persist(customer1);
		testEntityManager.persist(customer2);

		testEntityManager.remove(customer);

		List<Customer> customers = (List<Customer>) CustomerRepository.findAll();
		Assert.assertEquals(customers.size(), 1);

	}

	@Test
	public void testUpdateCustomerById() {
		Customer customer2 = new Customer();
		customer2.setUserId(45L);
		customer2.setName("bhumi");
		customer2.setEmail("bhumi@gmail.com");
		customer2.setContactNo("45687545");
		customer2.setDob(LocalDate.now());

		Customer saveInDb = testEntityManager.persist(customer2);

		Customer getFromDb = CustomerRepository.findById(customer2.getUserId()).get();

		assertThat(getFromDb).isEqualTo(saveInDb);

	}

	private Customer getCustomer() {
		Customer customer = new Customer();
		customer.setUserId(45L);
		customer.setName("bhumi");
		customer.setEmail("bhumi@gmail.com");
		customer.setContactNo("45687545");
		customer.setDob(LocalDate.now());

		return customer;

	}
}
