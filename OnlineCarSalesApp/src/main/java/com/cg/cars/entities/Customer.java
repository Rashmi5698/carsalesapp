package com.cg.cars.entities;
import javax.persistence.*;
import com.cg.cars.entities.Address;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
@Entity
@Table(name="Customer")
public class Customer {
	@Id
	private int userId;
	@Column
	private String name;
	private String email;
	private String contactNo;
	private  LocalDate dob;
	//@ManyToMany(cascade = CascadeType.ALL)
	//@JoinTable(name = "address_customer", joinColumns = { @JoinColumn(name = "address_no") },
		//inverseJoinColumns = { @JoinColumn(name = "customer_id") })
	//private Address address;
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(int userId, String name, String email, String contactNo, LocalDate dob) {
			//, Address address) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.contactNo = contactNo;
		this.dob = dob;
		//this.address = address;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
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

	/*public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}*/

	@Override
	public String toString() {
		return "Customer [userId=" + userId + ", name=" + name + ", email=" + email + ", contactNo=" + contactNo
				+ ", dob=" + dob + "]";
						//+ ", address=" + address + "]";
	}	
	
	
	
}
	
	
	