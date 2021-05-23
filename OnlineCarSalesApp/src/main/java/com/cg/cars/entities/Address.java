package com.cg.cars.entities;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;


@Entity
@Table(name="address")
public class Address {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ADDRESS_ID")
	private Long addressId;
	@Column(name="DOOR_NO")
	private Long doorNo;
	@Column(name="STREET")
	private String street;
	@Column(name="AREA")
	private String area;
	@Column(name="CITY")
	private String city;
	@Column(name="STATE")
	private String state;
	@Column(name="PINCODE")
	private Long pincode;
	
	
	@ManyToMany(mappedBy="address",cascade = CascadeType.ALL)
	private List<Customer>customers=new ArrayList<>();
	
	/*public Address(Long addressId,Long doorNo, String street, String area, String city, String state, Long pincode,List<Customer> customers) {
		super();
		this.addressId=addressId;
		this.doorNo = doorNo;
		this.street = street;
		this.area = area;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		this.customers = customers;
	}*/
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Long getAddressId() {
		return addressId;
	}
	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}
	public Long getDoorNo() {
		return doorNo;
	}
	public void setDoorNo(Long doorNo) {
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
	public Long getPincode() {
		return pincode;
	}
	public void setPincode(Long pincode) {
		this.pincode = pincode;
	}
	public List<Customer> getCustomers() {
		return customers;
	}
	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	/*@Override
	public String toString() {
		return "Address [addressId="+addressId+",doorNo=" + doorNo + ", street=" + street + ", area=" + area + ", city=" + city + ", state="
				+ state + ", pincode=" + pincode + ", customers=" + customers + "]";
	}*/
}
