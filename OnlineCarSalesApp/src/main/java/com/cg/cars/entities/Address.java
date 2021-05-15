package com.cg.cars.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;


@Entity
@Table(name="caddress")
public class Address {
	@Id
	private int doorNo;
	@Column
	private String street;
	private String area;
	private String city;
	private String state;
	private int pincode;
	//@ManyToMany(fetch=FetchType.LAZY,mappedBy="customers")
	//private Customer customers;
	public Address(int doorNo, String street, String area, String city, String state, int pincode) {
			//,Customer customers) {
		super();
		this.doorNo = doorNo;
		this.street = street;
		this.area = area;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		//this.customers = customers;
	}
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getDoorNo() {
		return doorNo;
	}
	public void setDoorNo(int doorNo) {
		this.doorNo = doorNo;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	/*public Customer getCustomers() {
		return customers;
	}
	public void setCustomers(Customer customers) {
		this.customers = customers;
	}*/
	@Override
	public String toString() {
		return "Address [doorNo=" + doorNo + ", street=" + street + ", area=" + area + ", city=" + city + ", state="
				+ state + ", pincode=" + pincode + "]";
						//+ ", customers=" + customers + "]";
	}
	
	
	
	
	
	
}
