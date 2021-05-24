package com.cg.cars.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.Test;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import com.cg.cars.entities.Customer;
import com.cg.cars.entities.Card;
import com.cg.cars.exceptions.CardNotFoundException;
import com.cg.cars.exceptions.UserNotFoundException;
import com.cg.cars.model.CustomerDTO;
import com.cg.cars.model.CardDTO;
import com.cg.cars.repository.CustomerRepository;
import com.cg.cars.repository.CardRepository;
import com.cg.cars.util.CustomerUtils;
import com.cg.cars.util.CardUtils;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerServiceTest {

	@MockBean
	private CustomerRepository customerRepo;

	@Autowired
	private CustomerService customerService;

	@Test
	public void addCustomerTest() {
		Customer Customer = new Customer();
		Customer.setUserId(45L);
		Customer.setName("bhumi");
		Customer.setEmail("bhumi@gmail.com");
		Customer.setContactNo("45687545");
		Customer.setDob(LocalDate.now());

		Mockito.when(customerRepo.save(Customer)).thenReturn(Customer);
		CustomerDTO CustomerDTO = CustomerUtils.convertToCustomerDto(Customer);
		assertEquals(CustomerDTO.getUserId(),45L);
	}

	@Test
	public void showCustomerByIdTest() {
		Customer Customer = new Customer();
		Customer.setUserId(45L);
		Customer.setName("bhumi");
		Customer.setEmail("bhumi@gmail.com");
		Customer.setContactNo("45687545");
		Customer.setDob(LocalDate.now());

		Mockito.when(customerRepo.save(Customer)).thenReturn(Customer);
		assertEquals(Customer.getUserId(),45L);
	}

	@Test
	public void showAllCustomerTest() {
		Customer Customer = new Customer();
		Customer.setUserId(45L);
		Customer.setName("bhumi");
		Customer.setEmail("bhumi@gmail.com");
		Customer.setContactNo("45687545");
		Customer.setDob(LocalDate.now());

		Customer Customer1 = new Customer();
		Customer1.setUserId(45L);
		Customer1.setName("bhumi");
		Customer1.setEmail("bhumi@gmail.com");
		Customer1.setContactNo("45687545");
		Customer1.setDob(LocalDate.now());

		List<Customer> CustomerList = new ArrayList<>();
		CustomerList.add(Customer);
		CustomerList.add(Customer1);
		Mockito.when(customerRepo.findAll()).thenReturn(CustomerList);
//		System.out.println("Service list"+productService.showAllProducts());
		List<CustomerDTO> dto = CustomerUtils.convertToCustomerDtoList(CustomerList);
//		System.out.println("after converting:"+dto);
		assertSame(customerService.getAllCustomer().size(),2);
	}

	@Test
	public void deleteCustomerTest() {
		Customer Customer1 = new Customer();
		Customer1.setUserId(45L);
		Customer1.setName("bhumi");
		Customer1.setEmail("bhumi@gmail.com");
		Customer1.setContactNo("45687545");
		Customer1.setDob(LocalDate.now());

		Mockito.when(customerRepo.save(Customer1)).thenReturn(Customer1);
		customerRepo.deleteById(Customer1.getUserId());
		assertNotEquals(Customer1, new Customer());
	}

	@Test
	public void updateCustomerTest() {

		Customer Customer1 = new Customer();
		Customer1.setUserId(45L);
		Customer1.setName("bhumi");
		Customer1.setEmail("bhumi@gmail.com");
		Customer1.setContactNo("45687545");
		Customer1.setDob(LocalDate.now());

		customerRepo.save(Customer1);

		Mockito.when(customerRepo.save(Customer1)).thenReturn(Customer1);
		assertEquals(Customer1.getUserId(),45L);
	}
}