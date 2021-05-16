package com.cg.cars.services;

import java.util.List;

import com.cg.cars.entities.Payment;

import com.cg.cars.model.PaymentDTO;



public interface PaymentService {
	
	public PaymentDTO addPayment(Payment payment);
	
	public PaymentDTO getPaymentById(long id);
	
	public List<PaymentDTO> getAllPayment();
	
	public void deletePayment(PaymentDTO paymentdto); 
	
	public void updatePayment(PaymentDTO paymentdto);
	
	//public Payment removePayment(long id);
	
	//public Payment updatePayment(long id, Payment payment);
	

	


	
}