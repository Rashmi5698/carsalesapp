package com.cg.cars.repository;

import org.junit.runner.RunWith;
import com.cg.cars.entities.Payment;
import com.cg.cars.entities.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.Date;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PaymentRepositoryTest {

	@Autowired
	private PaymentRepository paymentRepository;

	@Autowired
	private TestEntityManager testEntityManager;

	@Test
	public void testNewPayment() throws Exception {
		Payment payment = getPayment();
		Payment saveInDb = testEntityManager.persist(payment);
		Payment getFromInDb = paymentRepository.findById(saveInDb.getPaymentId()).get();
		assertThat(getFromInDb).isEqualTo(saveInDb);
	}

	@Test
	public void testGetPaymentById() throws Exception {
		Payment payment = new Payment();

		payment.setType("Online");
		payment.setStatus("Done");
		// Insert Data into in memory database
		Payment saveInDb = testEntityManager.persist(payment);
		// Get Data from DB
		Payment getInDb = paymentRepository.findById(payment.getPaymentId()).get();
		assertThat(getInDb).isEqualTo(saveInDb);
	}

	@Test
	public void testGetAllPayments() throws Exception {
		Payment payment1 = new Payment();

		payment1.setType("Online");
		payment1.setStatus("Done");

		Payment payment2 = new Payment();

		payment2.setType("Online");
		payment2.setStatus("Done");
		// Save into in memory database
		testEntityManager.persist(payment1);
		testEntityManager.persist(payment2);

		// Retrieve all tickets
		List<Payment> paymentList = (List<Payment>) paymentRepository.findAll();

		Assert.assertEquals(2, paymentList.size());
	}

	@Test
	public void testDeletePaymentById() throws Exception {
		Payment payment1 = new Payment();

		payment1.setType("Online");
		payment1.setStatus("Done");

		Payment payment2 = new Payment();

		payment2.setType("Online");
		payment2.setStatus("Done");

		Payment payment = testEntityManager.persist(payment1);
		testEntityManager.persist(payment2);

		testEntityManager.remove(payment);

		List<Payment> payments = (List<Payment>) paymentRepository.findAll();
		Assert.assertEquals(payments.size(), 1);

	}

	@Test
	public void testUpdatePaymentById() {
		Payment payment2 = new Payment();
		payment2.setType("Online");
		payment2.setStatus("Done");

		Payment saveInDb = testEntityManager.persist(payment2);

		Payment getFromDb = paymentRepository.findById(payment2.getPaymentId()).get();

		assertThat(getFromDb).isEqualTo(saveInDb);

	}

	private Payment getPayment() {
		Payment payment = new Payment();
		payment.setType("Online");
		payment.setStatus("Done");

		return payment;

	}
}
