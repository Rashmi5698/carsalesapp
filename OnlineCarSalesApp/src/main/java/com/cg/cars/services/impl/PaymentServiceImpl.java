package com.cg.cars.services.impl;

import java.util.List;
import java.util.Optional;

import com.cg.cars.entities.Payment;

import com.cg.cars.model.PaymentDTO;

import com.cg.cars.services.PaymentService;
import com.cg.cars.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.cars.util.PaymentUtils;


@Service
public class PaymentServiceImpl implements PaymentService{
	
	@Autowired
	private PaymentRepository paymentRepository;
	
	
public PaymentDTO addPayment(Payment payment){
	Payment paymentEntity=paymentRepository.save(payment);
	return PaymentUtils.convertToPaymentDto(paymentEntity);
}


public void deletePayment(PaymentDTO paymentdto) {
	
	paymentRepository.delete(PaymentUtils.convertToPayment(paymentdto));
	
}
	
public void updatePayment(PaymentDTO paymentdto) {
	
	paymentRepository.save(PaymentUtils.convertToPayment(paymentdto));
			
	
}

public PaymentDTO getPaymentById(long id) {
	Optional<Payment> existPayment=paymentRepository.findById(id);
	if(existPayment.isPresent()) {
		Payment payment=existPayment.get();
	return PaymentUtils.convertToPaymentDto(payment);
}
	else {
		return null;
	}
	
}


public List<PaymentDTO> getAllPayment(){
		List<Payment> paymentList=paymentRepository.findAll();
		return PaymentUtils.convertToPaymentDtoList(paymentList);
		}
}





