package com.cg.cars.model;

import java.time.LocalDate;
import org.springframework.stereotype.Component;
import com.cg.cars.entities.Address;
@Component
public class CustomerDTO {
	private int userId;
	private String name;
	private String email;
	private String contactNo;
	private  LocalDate dob;
	//private Address address;
	public CustomerDTO(int userId, String name, String email, String contactNo, LocalDate dob) {
			//, Address address) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.contactNo = contactNo;
		this.dob = dob;
		//this.address = address;
	}
	public CustomerDTO() {
		super();
		// TODO Auto-generated constructor stub
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
		return "CustomerDTO [userId=" + userId + ", name=" + name + ", email=" + email + ", contactNo=" + contactNo
				+ ", dob=" + dob + "]";
						//+ ", address=" + address + "]";
	}
	
    
}
