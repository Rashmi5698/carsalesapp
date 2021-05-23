package com.cg.cars.services.impl;

import java.util.List;
import java.util.Optional;

import com.cg.cars.entities.Customer;
import com.cg.cars.entities.Order;

import com.cg.cars.exceptions.OrderNotFoundException;
import com.cg.cars.model.CustomerDTO;
import com.cg.cars.model.OrderDTO;

import com.cg.cars.services.OrderService;
import com.cg.cars.repository.CustomerRepository;
import com.cg.cars.repository.OrderRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.cars.util.CustomerUtils;
import com.cg.cars.util.OrderUtils;

@Service
public class OrderServiceImpl implements OrderService {
	static final Logger LOGGER = LoggerFactory.getLogger(OrderServiceImpl.class);

	@Autowired
	private OrderRepository orderRepository;

	public OrderDTO addOrder(Order order) {
		LOGGER.info("addOrder() service is initiated");
		Order orderEntity = orderRepository.save(order);
		LOGGER.info("addOrder() service has executed");
		return OrderUtils.convertToOrderDto(orderEntity);
	}

	public Order updateOrderById(Long id, Order orderRequest) throws OrderNotFoundException {
		LOGGER.info("updateOrderById() service is initiated");
		return orderRepository.findById(id).map(order -> {
			order.setAmount(orderRequest.getAmount());
			order.setBillingDate(orderRequest.getBillingDate());
			LOGGER.info("updateOrderById() service has executed");
			return orderRepository.save(order);
		}).orElseThrow(() -> new OrderNotFoundException("order with id not present"));

	}

	public OrderDTO getOrderById(Long id) throws OrderNotFoundException {
		LOGGER.info("getOrderById() service is initiated");
		Optional<Order> existOrder = orderRepository.findById(id);
		if (existOrder.isPresent()) {
			Order order = existOrder.get();
			LOGGER.info("getOrderById() service has executed");
			return OrderUtils.convertToOrderDto(order);
		} else {
			throw new OrderNotFoundException("Order with id not present");
		}

	}

	public List<OrderDTO> getAllOrders() {
		LOGGER.info("getAllOrders() service is initiated");
		List<Order> orderList = orderRepository.findAll();
		LOGGER.info("getAllOrders() service has executed");
		return OrderUtils.convertToOrderDtoList(orderList);
	}

	public OrderDTO deleteOrderById(Long id) throws OrderNotFoundException {
		LOGGER.info("deleteOrderById() service is initiated");
		Order orderexist = orderRepository.findById(id).orElse(null);
		if (orderexist == null)
			throw new OrderNotFoundException("Order with id not present");
		else
			orderRepository.delete(orderexist);
		LOGGER.info("deleteOrderById() service has executed");
		return OrderUtils.convertToOrderDto(orderexist);
	}

}
