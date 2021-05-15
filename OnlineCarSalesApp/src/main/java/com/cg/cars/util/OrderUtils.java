package com.cg.cars.util;

import com.cg.cars.model.OrderDTO;
import com.cg.cars.entities.Customer;
import com.cg.cars.entities.Order;
import java.util.List;

import javax.persistence.Column;

import java.time.LocalDate;
import java.util.ArrayList;

public class OrderUtils {
	private OrderUtils() {
	}
	//converting into screen class
	public static List<OrderDTO> convertToOrderDtoList(List<Order> list){
		List<OrderDTO> dtolist=new ArrayList<OrderDTO>();
		for(Order order :list)
			dtolist.add(convertToOrderDto(order));
		return dtolist;
}
	
	public static Order convertToOrder(OrderDTO dto) {
		Order order= new Order();
	
		order.setOrderId(dto.getOrderId());
		order.setAmount(dto.getAmount());
		order.setBillingDate(dto.getBillingDate());
		//order.setCustomer(dto.getCustomer());
		
	return order;	
	}
	
	public static OrderDTO convertToOrderDto(Order order ) {
		OrderDTO dto=new OrderDTO();
		dto.setOrderId(order.getOrderId());
		dto.setAmount(order.getAmount());
		dto.setBillingDate(order.getBillingDate());
		//dto.setCustomer(order.getCustomer());
	
	return dto;	
	}
}
