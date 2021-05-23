package com.cg.cars.services;

import java.util.List;

import com.cg.cars.entities.Order;
import com.cg.cars.exceptions.OrderNotFoundException;
import com.cg.cars.model.OrderDTO;

public interface OrderService {

	public OrderDTO addOrder(Order order);

	public OrderDTO getOrderById(Long id) throws OrderNotFoundException;

	public List<OrderDTO> getAllOrders();

	public Order updateOrderById(Long id, Order orderRequest) throws OrderNotFoundException;

	public OrderDTO deleteOrderById(Long id) throws OrderNotFoundException;

}