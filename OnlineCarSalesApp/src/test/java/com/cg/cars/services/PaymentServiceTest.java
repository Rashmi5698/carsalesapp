package com.cg.cars.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.Test;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import com.cg.cars.entities.Payment;
import com.cg.cars.entities.Card;
import com.cg.cars.exceptions.CardNotFoundException;
import com.cg.cars.exceptions.UserNotFoundException;
import com.cg.cars.model.PaymentDTO;
import com.cg.cars.model.CardDTO;
import com.cg.cars.repository.PaymentRepository;
import com.cg.cars.repository.CardRepository;
import com.cg.cars.repository.PaymentRepository;
import com.cg.cars.util.PaymentUtils;
import com.cg.cars.util.CardUtils;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PaymentServiceTest {

	@MockBean
	private PaymentRepository paymentRepo;

	@Autowired
	private PaymentService paymentService;

	@Test
	public void addPaymentTest() {
		Payment Payment = new Payment();
		Payment.setPaymentId(32L);
		Payment.setType("Online");
		Payment.setStatus("Done");

		Mockito.when(paymentRepo.save(Payment)).thenReturn(Payment);
		PaymentDTO PaymentDTO = PaymentUtils.convertToPaymentDto(Payment);
		assertEquals(PaymentDTO.getPaymentId(), 32L);
	}

	@Test
	public void showPaymentByIdTest() throws UserNotFoundException {
		Payment Payment = new Payment();
		Payment.setPaymentId(32L);
		Payment.setType("Online");
		Payment.setStatus("Done");

		Mockito.when(paymentRepo.save(Payment)).thenReturn(Payment);
		assertEquals(Payment.getPaymentId(), 32L);
	}

	@Test
	public void showAllPaymentTest() throws UserNotFoundException {
		Payment Payment = new Payment();
		Payment.setPaymentId(32L);
		Payment.setType("Online");
		Payment.setStatus("Done");

		Payment Payment1 = new Payment();
		Payment1.setPaymentId(32L);
		Payment1.setType("Online");
		Payment1.setStatus("Done");

		List<Payment> PaymentList = new ArrayList<>();
		PaymentList.add(Payment);
		PaymentList.add(Payment1);
		Mockito.when(paymentRepo.findAll()).thenReturn(PaymentList);
//		System.out.println("Service list"+productService.showAllProducts());
		List<PaymentDTO> dto = PaymentUtils.convertToPaymentDtoList(PaymentList);
//		System.out.println("after converting:"+dto);
		assertSame(paymentService.getAllPayment().size(), 2);
	}

	@Test
	public void deletePaymentTest() {
		Payment Payment1 = new Payment();
		Payment1.setPaymentId(32L);
		Payment1.setType("Online");
		Payment1.setStatus("Done");

		Mockito.when(paymentRepo.save(Payment1)).thenReturn(Payment1);
		paymentRepo.deleteById(Payment1.getPaymentId());
		assertNotEquals(Payment1, new Payment());
	}

	@Test
	public void updatePaymentTest() {

		Payment Payment1 = new Payment();
		Payment1.setPaymentId(32L);
		Payment1.setType("Online");
		Payment1.setStatus("Done");

		paymentRepo.save(Payment1);

		Mockito.when(paymentRepo.save(Payment1)).thenReturn(Payment1);
		assertEquals(Payment1.getPaymentId(), 32L);
	}
}