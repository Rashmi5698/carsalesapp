package com.cg.cars.services.impl;

import java.util.List;
import java.util.Optional;

import com.cg.cars.entities.Order;

import com.cg.cars.model.OrderDTO;

import com.cg.cars.services.OrderService;
import com.cg.cars.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.cars.util.OrderUtils;

@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	private OrderRepository orderRepository;
	
	
public OrderDTO addOrder(Order order){
	Order orderEntity=orderRepository.save(order);
	return OrderUtils.convertToOrderDto(orderEntity);
}


public void deleteOrder(OrderDTO orderdto) {
	
	orderRepository.delete(OrderUtils.convertToOrder(orderdto));
	
}
	
public void updateOrder(OrderDTO orderdto) {
	
	orderRepository.save(OrderUtils.convertToOrder(orderdto));
			
	
}

public OrderDTO getOrderById(long id) {
	Optional<Order> existOrder=orderRepository.findById(id);
	if(existOrder.isPresent()) {
		Order order=existOrder.get();
	return OrderUtils.convertToOrderDto(order);
}
	else {
		return null;
	}
	
}


public List<OrderDTO> getAllOrders(){
		List<Order> orderList=orderRepository.findAll();
		return OrderUtils.convertToOrderDtoList(orderList);
		}
}





