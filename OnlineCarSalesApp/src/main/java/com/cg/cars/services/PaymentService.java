package com.cg.cars.services;

import java.util.List;

import com.cg.cars.entities.Payment;

import com.cg.cars.exceptions.PaymentNotFoundException;

import com.cg.cars.model.PaymentDTO;



public interface PaymentService {
	
	public PaymentDTO addPayment(Payment payment);
	
	public PaymentDTO getPaymentById(Long id) throws PaymentNotFoundException;
	
	public List<PaymentDTO> getAllPayment();
	
	public PaymentDTO deletePaymentById(Long id)throws PaymentNotFoundException; 
	
	public Payment updatePaymentById(Long id, Payment paymentRequest) throws PaymentNotFoundException;
	

	


	
}