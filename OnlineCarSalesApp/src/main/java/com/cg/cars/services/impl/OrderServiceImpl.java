package com.cg.cars.services.impl;

import java.util.List;
import java.util.Optional;


import com.cg.cars.entities.Order;

import com.cg.cars.exceptions.OrderNotFoundException;

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

public Order updateOrderById(Long id, Order orderRequest) throws OrderNotFoundException{
    return orderRepository.findById(id).map( order-> {
    	order.setAmount(orderRequest.getAmount());
    	order.setBillingDate(orderRequest.getBillingDate());
    	
    return orderRepository.save(order);
    }).orElseThrow(()-> new OrderNotFoundException("order with id not present"));
    
}
public OrderDTO getOrderById(Long id) throws OrderNotFoundException{
	Optional<Order> existOrder=orderRepository.findById(id);
	if(existOrder.isPresent()) {
		Order order=existOrder.get();
	return OrderUtils.convertToOrderDto(order);
}
	else {
		throw new OrderNotFoundException("Order with id not present");
	}
	
}


public List<OrderDTO> getAllOrders(){
		List<Order> orderList=orderRepository.findAll();
		return OrderUtils.convertToOrderDtoList(orderList);
		}
public OrderDTO deleteOrderById(Long id)throws OrderNotFoundException {
	Order orderexist=orderRepository.findById(id).orElse(null);
	if(orderexist==null)
		throw new OrderNotFoundException("Order with id not present");
	else
		orderRepository.delete(orderexist);
	return OrderUtils.convertToOrderDto(orderexist);
	}

}





