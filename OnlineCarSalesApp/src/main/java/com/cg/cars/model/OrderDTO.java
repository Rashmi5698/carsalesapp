package com.cg.cars.model;

import com.cg.cars.entities.Payment;
import java.time.LocalDate;

import org.springframework.stereotype.Component;

@Component
public class OrderDTO {
	private long orderId;
	private double amount;
	private LocalDate billingDate;
	private Payment payment;

	public OrderDTO() {
		super();

	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
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
