package com.cg.cars.util;

import com.cg.cars.model.PaymentDTO;

import com.cg.cars.entities.Payment;
import java.util.List;

import java.util.ArrayList;

public class PaymentUtils {
	private PaymentUtils() {
	}

	public static List<PaymentDTO> convertToPaymentDtoList(List<Payment> list) {
		List<PaymentDTO> dtolist = new ArrayList<>();
		for (Payment payment : list)
			dtolist.add(convertToPaymentDto(payment));
		return dtolist;
	}

	public static PaymentDTO convertToPaymentDto(Payment payment) {
		PaymentDTO dto = new PaymentDTO();
		dto.setPaymentId(payment.getPaymentId());
		dto.setType(payment.getType());
		dto.setStatus(payment.getStatus());
		dto.setCard(payment.getCard());
		return dto;
	}
}
