package com.cg.cars.controller;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.cars.services.PaymentService;
import com.cg.cars.model.PaymentDTO;
import com.cg.cars.entities.Payment;
import com.cg.cars.exceptions.PaymentNotFoundException;


@RestController
@RequestMapping("/api/cars")
public class PaymentController {
	static final Logger LOGGER = LoggerFactory.getLogger(PaymentController.class);
	
	@Autowired
	private PaymentService paymentService;
	/************************************************************************************
	 * Method: addPayment
	 * Description: It is used to add Payment into Payments table
	 * @param Payment: Payment's reference variable.
	 * @returns Payment: It returns Payment with details
	 * @PostMapping: It is used to handle the HTTP POST requests matched with given URI expression.
	 * @RequestBody: It used to bind the HTTP request/response body with a domain object in method parameter or return type.
	
	 ************************************************************************************/
	@PostMapping("/add-payment")
	public ResponseEntity<Object> insertPayment(@RequestBody Payment payment)
	{
		LOGGER.info("add-Payment URL is opened");
		LOGGER.info("addPayment() is initiated");
		PaymentDTO paymentDTO = null;
		ResponseEntity<Object> paymentResponse = null;
		paymentDTO =paymentService.addPayment(payment);
		paymentResponse = new ResponseEntity<Object>(paymentDTO, HttpStatus.ACCEPTED);
		LOGGER.info("addPayment() has executed");
		return paymentResponse;
	}
	/************************************************************************************
	 * Method: getPaymentById 
	 * Description: It is used to view Payment by id from Payments table
	 * @param Payment: Long id
	 * @returns Payment: It returns Payment with details
	 * @GetMapping: It is used to handle the HTTP GET requests matched with given URI expression.
	 * @RequestBody: It used to bind the HTTP request/response body with a domain object in method parameter or return type.
	 ************************************************************************************/
	@GetMapping("/view-payment/{id}")
	public ResponseEntity getPaymentById(@PathVariable Long id) throws  PaymentNotFoundException{
		LOGGER.info("view-Payment URL is opened");
		LOGGER.info("viewPayment() is initiated");
		PaymentDTO PaymentDTO = paymentService.getPaymentById(id);
		LOGGER.info("viewPayment() has executed");
		return new ResponseEntity(PaymentDTO, HttpStatus.OK);
	}
	/************************************************************************************
	 * Method: getAllPayments 
	 * Description: It is used to view all Payments in Payments table
	 * @returns Payment: It returns Payment with details
	 * @GetMapping: It is used to handle the HTTP GET requests matched with given URI expression.
	 * @RequestBody: It used to bind the HTTP request/response body with a domain object in method parameter or return type.
	 ************************************************************************************/
	
	@GetMapping("/view-all-payment")
	public List<PaymentDTO> viewAllPayment() {
		LOGGER.info("view-all-Payment URL is opened");
		LOGGER.info("viewAllPayment() is initiated");
		LOGGER.info("viewAllPayment() has executed");
		return paymentService.getAllPayment();
	}
	/************************************************************************************
	 * Method: DeletePayment 
	 * Description: It is used to remove Payment from Payments table
	 * @param Payment: Long id
	 * @returns Payment: It returns Payment with details
	 * @DeleteMapping: It is used to handle the HTTP DELETE requests matched with given URI expression.
	 * @RequestBody: It used to bind the HTTP request/response body with a domain object in method parameter or return type.
	 ************************************************************************************/
	@DeleteMapping("/delete-payment/{id}")
	public ResponseEntity<Object> deletePaymentById(@PathVariable Long id) throws PaymentNotFoundException{
		LOGGER.info("delete-Payment URL is opened");
		LOGGER.info("deletePayment() is initiated");
		paymentService.deletePaymentById(id);
		LOGGER.info("deletePayment() has executed");
		return new ResponseEntity("deleted successfully:", HttpStatus.ACCEPTED);
}
	
	/************************************************************************************
	 * Method: updatePayment 
	 * Description: It is used to update Payment into Payment table
	 * @param Payment: Payment's reference variable.
	 * @returns Payment: It returns Payment with details
	 * @PutMapping: It is used to handle the HTTP PUT requests matched with given URI expression.
	 * @RequestBody: It used to bind the HTTP request/response body with a domain object in method parameter or return type.
	 ************************************************************************************/
	@PutMapping("/update-payment/{id}")
	
    public ResponseEntity updatePayment(@PathVariable Long id, @RequestBody Payment paymentRequest) throws PaymentNotFoundException {
		LOGGER.info("update-Payment URL is opened");
		LOGGER.info("updatePayment() is initiated");
		paymentService.updatePaymentById(id,paymentRequest);
		LOGGER.info("updatePayment() has executed");
		return new ResponseEntity("Updated ", HttpStatus.OK);
	}


}
