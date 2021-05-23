package com.cg.cars.services.impl;

import java.util.List;
import java.util.Optional;

import com.cg.cars.entities.Payment;

import com.cg.cars.exceptions.PaymentNotFoundException;

import com.cg.cars.model.PaymentDTO;

import com.cg.cars.services.PaymentService;
import com.cg.cars.repository.PaymentRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.cars.util.PaymentUtils;

@Service
public class PaymentServiceImpl implements PaymentService {
	static final Logger LOGGER = LoggerFactory.getLogger(PaymentServiceImpl.class);

	@Autowired
	private PaymentRepository paymentRepository;

	public PaymentDTO addPayment(Payment payment) {
		LOGGER.info("addPayment() service is initiated");
		Payment paymentEntity = paymentRepository.save(payment);
		LOGGER.info("addPayment() service has executed");
		return PaymentUtils.convertToPaymentDto(paymentEntity);
	}

	public PaymentDTO getPaymentById(Long id) throws PaymentNotFoundException {
		LOGGER.info("getPaymentById() service is initiated");
		Optional<Payment> existPayment = paymentRepository.findById(id);
		if (existPayment.isPresent()) {
			Payment payment = existPayment.get();
			LOGGER.info("getPaymentById() service has executed");
			return PaymentUtils.convertToPaymentDto(payment);
		} else {
			throw new PaymentNotFoundException("payment with id not present");
		}

	}

	public List<PaymentDTO> getAllPayment() {
		LOGGER.info("getAllPayment() service is initiated");
		List<Payment> paymentList = paymentRepository.findAll();
		LOGGER.info("getAllPayment() service has executed");
		return PaymentUtils.convertToPaymentDtoList(paymentList);
	}

	public PaymentDTO deletePaymentById(Long id) throws PaymentNotFoundException {
		LOGGER.info("deletePayment() service is initiated");
		Payment paymentexist = paymentRepository.findById(id).orElse(null);
		if (paymentexist == null)
			throw new PaymentNotFoundException("payment with id not present");
		else
			paymentRepository.delete(paymentexist);
		LOGGER.info("deletePayment() service has executed");
		return PaymentUtils.convertToPaymentDto(paymentexist);
	}

	public Payment updatePaymentById(Long id, Payment paymentRequest) throws PaymentNotFoundException {
		LOGGER.info("updatePayment() service is initiated");
		return paymentRepository.findById(id).map(payment -> {
			payment.setType(paymentRequest.getType());
			payment.setStatus(paymentRequest.getStatus());
			LOGGER.info("updatePayment() service has executed");
			return paymentRepository.save(payment);
		}).orElseThrow(() -> new PaymentNotFoundException("payment with id not present"));

	}
}