package com.cg.cars.entities;

import java.time.LocalDate;
import javax.persistence.*;

@Entity
@Table(name = "iorder")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long orderId;
	@Column
	private double amount;
	private LocalDate billingDate;
	@OneToOne(cascade = { CascadeType.ALL, CascadeType.DETACH, CascadeType.REFRESH })
	@JoinColumn(name = "payment_id")
	private Payment payment;

	public Order() {
		super();

	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public LocalDate getBillingDate() {
		return billingDate;
	}

	public void setBillingDate(LocalDate billingDate) {
		this.billingDate = billingDate;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

}
