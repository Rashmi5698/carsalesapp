package com.cg.cars.util;

import com.cg.cars.model.PaymentDTO;
import com.cg.cars.entities.Card;
import com.cg.cars.entities.Payment;
import java.util.List;

import javax.persistence.Column;

import java.util.ArrayList;

public class PaymentUtils {
	private PaymentUtils() {
	}
	//converting into screen class
	public static List<PaymentDTO> convertToPaymentDtoList(List<Payment> list){
		List<PaymentDTO> dtolist=new ArrayList<PaymentDTO>();
		for(Payment payment :list)
			dtolist.add(convertToPaymentDto(payment));
		return dtolist;
}
	
	public static Payment convertToPayment(PaymentDTO dto) {
		Payment payment= new Payment();
	
		payment.setPaymentId(dto.getPaymentId());
		payment.setType(dto.getType());
		payment.setStatus(dto.getStatus());
		//payment.setCard(dto.getCard());
		
	return payment;	
	}
	
	public static PaymentDTO convertToPaymentDto(Payment payment ) {
		PaymentDTO dto=new PaymentDTO();
		dto.setPaymentId(payment.getPaymentId());
		dto.setType(payment.getType());
		dto.setStatus(payment.getStatus());
		//dto.setCard(payment.getCard());
		
	return dto;	
	}
}
