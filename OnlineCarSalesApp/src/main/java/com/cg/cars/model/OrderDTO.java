package com.cg.cars.model;
import com.cg.cars.entities.Customer;

import java.time.LocalDate;
import javax.persistence.*;
import org.springframework.stereotype.Component;
@Component
public class OrderDTO {
	private long orderId;
	private double amount;
	private LocalDate billingDate;
	//private Customer customer;
	public OrderDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OrderDTO(long orderId, double amount, LocalDate billingDate) {
			//, Customer customer) {
		super();
		this.orderId = orderId;
		this.amount = amount;
		this.billingDate = billingDate;
		//this.customer = customer;
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
	/*public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}*/
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", amount=" + amount + ", billingDate=" + billingDate + "]";
				//+ ", customer="+ customer + "]";
	}
	

}
