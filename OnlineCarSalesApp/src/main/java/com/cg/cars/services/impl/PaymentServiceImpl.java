package com.cg.cars.services.impl;

import java.util.List;
import java.util.Optional;

import com.cg.cars.entities.Payment;

import com.cg.cars.exceptions.PaymentNotFoundException;

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



public PaymentDTO getPaymentById(Long id) throws PaymentNotFoundException {
	Optional<Payment> existPayment=paymentRepository.findById(id);
	if(existPayment.isPresent()) {
		Payment payment=existPayment.get();
	return PaymentUtils.convertToPaymentDto(payment);
}
	else {
		throw new PaymentNotFoundException("payment with id not present");
	}
	
}


public List<PaymentDTO> getAllPayment(){
		List<Payment> paymentList=paymentRepository.findAll();
		return PaymentUtils.convertToPaymentDtoList(paymentList);
		}

public PaymentDTO deletePaymentById(Long id)throws PaymentNotFoundException {
	Payment paymentexist=paymentRepository.findById(id).orElse(null);
	if(paymentexist==null)
		throw new PaymentNotFoundException("payment with id not present");
	else
		paymentRepository.delete(paymentexist);
	return PaymentUtils.convertToPaymentDto(paymentexist);
	}



public Payment updatePaymentById(Long id, Payment paymentRequest) throws PaymentNotFoundException{
    return paymentRepository.findById(id).map( payment-> {
    	payment.setType(paymentRequest.getType());
    	payment.setStatus(paymentRequest.getStatus());
    return paymentRepository.save(payment);
    }).orElseThrow(()-> new PaymentNotFoundException("payment with id not present"));
    
}
}