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

import com.cg.cars.entities.Order;
import com.cg.cars.entities.Card;
import com.cg.cars.exceptions.CardNotFoundException;
import com.cg.cars.exceptions.UserNotFoundException;
import com.cg.cars.model.OrderDTO;
import com.cg.cars.model.CardDTO;
import com.cg.cars.repository.OrderRepository;
import com.cg.cars.repository.CardRepository;
import com.cg.cars.util.OrderUtils;
import com.cg.cars.util.CardUtils;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderServiceTest {

	@MockBean
	private OrderRepository orderRepo;

	@Autowired
	private OrderService orderService;

	@Test
	public void addOrderTest() {
		Order Order = new Order();
		Order.setOrderId(4545L);
		Order.setAmount(45.00);
		Order.setBillingDate(LocalDate.now());
		Mockito.when(orderRepo.save(Order)).thenReturn(Order);
		OrderDTO OrderDTO = OrderUtils.convertToOrderDto(Order);
		assertEquals(OrderDTO.getOrderId(), 4545L);
	}

	@Test
	public void showOrderByIdTest() {
		Order Order = new Order();
		Order.setOrderId(4545L);
		Order.setAmount(45.00);
		Order.setBillingDate(LocalDate.now());

		Mockito.when(orderRepo.save(Order)).thenReturn(Order);
		assertEquals(Order.getOrderId(), 4545L);
	}

	@Test
	public void showAllOrderTest() throws UserNotFoundException {
		Order Order = new Order();
		Order.setOrderId(4545L);
		Order.setAmount(45.00);
		Order.setBillingDate(LocalDate.now());

		Order Order1 = new Order();
		Order1.setOrderId(4545L);
		Order1.setAmount(45.00);
		Order1.setBillingDate(LocalDate.now());

		List<Order> OrderList = new ArrayList<>();
		OrderList.add(Order);
		OrderList.add(Order1);
		Mockito.when(orderRepo.findAll()).thenReturn(OrderList);
//		System.out.println("Service list"+productService.showAllProducts());
		List<OrderDTO> dto = OrderUtils.convertToOrderDtoList(OrderList);
//		System.out.println("after converting:"+dto);
		assertSame(orderService.getAllOrders().size(), 2);
	}

	@Test
	public void deleteOrderTest() {
		Order Order1 = new Order();
		Order1.setOrderId(4545L);
		Order1.setAmount(45.00);
		Order1.setBillingDate(LocalDate.now());

		Mockito.when(orderRepo.save(Order1)).thenReturn(Order1);
		orderRepo.deleteById(Order1.getOrderId());
		assertNotEquals(Order1, new Order());
	}

	@Test
	public void updateOrderTest() {

		Order Order1 = new Order();

		Order1.setOrderId(4545L);
		Order1.setAmount(45.00);
		Order1.setBillingDate(LocalDate.now());

		orderRepo.save(Order1);

		Mockito.when(orderRepo.save(Order1)).thenReturn(Order1);
		assertEquals(Order1.getOrderId(), 4545L);
	}
}