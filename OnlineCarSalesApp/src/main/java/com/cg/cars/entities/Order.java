package com.cg.cars.entities;

import java.time.LocalDate;
import javax.persistence.*;
@Entity 
@Table(name="iorder")
public class Order {
	
	@Id
	private long orderId;
	@Column
	private double amount;
	private LocalDate billingDate;
	//private Customer customer;
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Order(long orderId, double amount, LocalDate billingDate) {
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
