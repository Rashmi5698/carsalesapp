package com.cg.cars.model;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;
import com.cg.cars.entities.Customer;
@Component
public class AddressDTO {
	private Long addressId;
	private Long doorNo;
	private String street;
	private String area;
	private String city;
	private String state;
	private Long pincode;
	private List<Customer>customers=new ArrayList<>();
	
	
	public List<Customer> getCustomers() {
		return customers;
	}
	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}
	/*public AddressDTO(Long addressId,Long doorNo, String street, String area, String city, String state, Long pincode,List<Customer> customers) {
		super();
		this.addressId=addressId;
		this.doorNo = doorNo;
		this.street = street;
		this.area = area;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		this.customers=customers;
	}*/
	public AddressDTO() {
		super();
		// TODO Auto-generated constructor stub
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
	
	public Long getAddressId() {
		return addressId;
	}
	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}
	/*@Override
	public String toString() {
		return "AddressDTO [addressId="+addressId+",doorNo=" + doorNo + ", street=" + street + ", area=" + area + ", city=" + city + ", state="
				+ state + ", pincode=" + pincode + "Customer="+customers+"]";
	}	*/
}
