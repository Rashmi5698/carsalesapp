package com.cg.cars.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "customers")
public class Customer {
	@Id
	@Column(name = "CUSTOMER_ID")

	private Long userId;
	@Column
	private String name;
	private String email;
	private String contactNo;
	private LocalDate dob;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "CUSTOMER_ADDRESS", joinColumns = { @JoinColumn(name = "CUSTOMER_ID") }, inverseJoinColumns = {
			@JoinColumn(name = "ADDRESS_ID") })
	private List<Address> address = new ArrayList<>();

	@OneToMany(cascade = { CascadeType.ALL, CascadeType.DETACH, CascadeType.REFRESH })
	@JoinTable(name = "CUSTOMER_APPOINTMENT", joinColumns = {
			@JoinColumn(name = "CUSTOMER_ID") }, inverseJoinColumns = { @JoinColumn(name = "APPOINTMENT_ID") })
	private List<Appointment> appointment = new ArrayList<>();

	@OneToMany(cascade = { CascadeType.ALL, CascadeType.DETACH, CascadeType.REFRESH })
	@JoinTable(name = "CUSTOMER_ORDER", joinColumns = { @JoinColumn(name = "CUSTOMER_ID") }, inverseJoinColumns = {
			@JoinColumn(name = "ORDER_ID") })
	private List<Order> iorder = new ArrayList<>();

	@OneToMany(cascade = { CascadeType.ALL, CascadeType.DETACH, CascadeType.REFRESH })
	@JoinTable(name = "CUSTOMER_CAR", joinColumns = { @JoinColumn(name = "CUSTOMER_ID") }, inverseJoinColumns = {
			@JoinColumn(name = "CAR_ID") })
	private List<Car> car = new ArrayList<>();

	@OneToOne(cascade = { CascadeType.ALL, CascadeType.DETACH, CascadeType.REFRESH })
	@JoinColumn(name = "user_id")
	private User user;

	public Customer() {
		super();

	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public List<Address> getAddress() {
		return address;
	}

	/*
	 * public void setAddress(List<Address> address) { this.address = address; }
	 */

	public List<Appointment> getAppointment() {
		return appointment;
	}

	/*
	 * public void setAppointment(List<Appointment> appointment) { this.appointment
	 * = appointment; }
	 */

	public List<Order> getIorder() {
		return iorder;
	}

	/*
	 * public void setIorder(List<Order> iorder) { this.iorder = iorder; }
	 */

	public List<Car> getCar() {
		return car;
	}

	public void setCar(List<Car> car) {
		this.car = car;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
