package com.cg.cars.util;

import com.cg.cars.model.OrderDTO;
import com.cg.cars.entities.Order;
import java.util.List;
import java.util.ArrayList;

public class OrderUtils {
	private OrderUtils() {
	}

	
	public static List<OrderDTO> convertToOrderDtoList(List<Order> list) {
		List<OrderDTO> dtolist = new ArrayList<OrderDTO>();
		for (Order order : list)
			dtolist.add(convertToOrderDto(order));
		return dtolist;
	}

	public static OrderDTO convertToOrderDto(Order order) {
		OrderDTO dto = new OrderDTO();
		dto.setOrderId(order.getOrderId());
		dto.setAmount(order.getAmount());
		dto.setBillingDate(order.getBillingDate());
		dto.setPayment(order.getPayment());
		return dto;
	}
}
