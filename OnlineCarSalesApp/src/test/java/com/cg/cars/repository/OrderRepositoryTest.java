package com.cg.cars.repository;

import org.junit.runner.RunWith;
import com.cg.cars.entities.Order;
import com.cg.cars.entities.User;
import com.cg.cars.exceptions.OrderNotFoundException;

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
public class OrderRepositoryTest {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private TestEntityManager testEntityManager;

	@Test
	public void testNewOrder()  {
		Order order = getOrder();
		Order saveInDb = testEntityManager.persist(order);
		Order getFromInDb = orderRepository.findById(saveInDb.getOrderId()).get();
		assertThat(getFromInDb).isEqualTo(saveInDb);
	}

	@Test
	public void testGetOrderById() throws OrderNotFoundException {
		Order order = new Order();

		order.setAmount(45.00);
		order.setBillingDate(LocalDate.now());
		// Insert Data into in memory database
		Order saveInDb = testEntityManager.persist(order);
		// Get Data from DB
		Order getInDb = orderRepository.findById(order.getOrderId()).get();
		assertThat(getInDb).isEqualTo(saveInDb);
	}

	@Test
	public void testGetAllOrders() {
		Order order1 = new Order();

		order1.setAmount(45.00);
		order1.setBillingDate(LocalDate.now());

		Order order2 = new Order();

		order2.setAmount(45.00);
		order2.setBillingDate(LocalDate.now());
		// Save into in memory database
		testEntityManager.persist(order1);
		testEntityManager.persist(order2);

		// Retrieve all tickets
		List<Order> orderList = (List<Order>) orderRepository.findAll();

		Assert.assertEquals(2, orderList.size());
	}

	@Test
	public void testDeleteOrderById() throws OrderNotFoundException {
		Order order1 = new Order();

		order1.setAmount(45.00);
		order1.setBillingDate(LocalDate.now());

		Order order2 = new Order();

		order2.setAmount(45.00);
		order2.setBillingDate(LocalDate.now());

		Order order = testEntityManager.persist(order1);
		testEntityManager.persist(order2);
		
		testEntityManager.remove(order);

		List<Order> orders = (List<Order>) orderRepository.findAll();
		Assert.assertEquals(orders.size(), 1);

	}

	@Test
	public void testUpdateOrderById()throws OrderNotFoundException {
		Order order2 = new Order();
		
		order2.setAmount(45.00);
		order2.setBillingDate(LocalDate.now());
		Order saveInDb = testEntityManager.persist(order2);

		Order getFromDb = orderRepository.findById(order2.getOrderId()).get();

		assertThat(getFromDb).isEqualTo(saveInDb);

	}

	private Order getOrder() {
		Order order = new Order();
		order.setAmount(45.00);
		order.setBillingDate(LocalDate.now());
		return order;

	}
}
