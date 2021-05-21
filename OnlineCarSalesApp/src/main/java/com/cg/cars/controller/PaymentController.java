package com.cg.cars.controller;
import java.util.List;
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


//@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/api/cars")
public class PaymentController {
	
	@Autowired
	private PaymentService paymentService;
	@PostMapping("/add-payment")
	public ResponseEntity<Object> insertPayment(@RequestBody Payment payment)
	{
		PaymentDTO paymentDTO = null;
		ResponseEntity<Object> paymentResponse = null;
		paymentDTO =paymentService.addPayment(payment);
		paymentResponse = new ResponseEntity<Object>(paymentDTO, HttpStatus.ACCEPTED);
		return paymentResponse;
	}
	@GetMapping("/view-payment/{id}")
	public ResponseEntity getAddressById(@PathVariable Long id) throws  PaymentNotFoundException{
	
		PaymentDTO addressDTO = paymentService.getPaymentById(id);
		
		return new ResponseEntity(addressDTO, HttpStatus.OK);
	}
	
	
	@GetMapping("/view-all-payment")
	public List<PaymentDTO> viewAllPayment() {
		
		return paymentService.getAllPayment();
	}
	@DeleteMapping("/delete-payment/{id}")
	public ResponseEntity<Object> deletePaymentById(@PathVariable Long id) throws PaymentNotFoundException{
	
		paymentService.deletePaymentById(id);
	
		return new ResponseEntity("deleted successfully:", HttpStatus.ACCEPTED);
}
	@PutMapping("/update-payment/{id}")
	
    public ResponseEntity updatePayment(@PathVariable Long id, @RequestBody Payment paymentRequest) throws PaymentNotFoundException {
		paymentService.updatePaymentById(id,paymentRequest);
		return new ResponseEntity("Updated ", HttpStatus.OK);
	}


}
