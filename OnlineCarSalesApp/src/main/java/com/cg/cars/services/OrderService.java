package com.cg.cars.services;

import java.util.List;

import com.cg.cars.entities.Order;

import com.cg.cars.model.OrderDTO;
import com.cg.cars.entities.Order;


public interface OrderService {
	
	public OrderDTO addOrder(Order order);
	
	public OrderDTO getOrderById(long id);
	
	public List<OrderDTO> getAllOrders();
	
	public void deleteOrder(OrderDTO orderdto); 
	
	public void updateOrder(OrderDTO orderdto);
	


	
}