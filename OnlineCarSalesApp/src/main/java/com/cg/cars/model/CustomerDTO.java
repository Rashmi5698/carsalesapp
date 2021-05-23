package com.cg.cars.model;
import com.cg.cars.entities.User;
import com.cg.cars.entities.Appointment;
import com.cg.cars.entities.Car;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;
import com.cg.cars.entities.Address;
import com.cg.cars.entities.Order;
@Component
public class CustomerDTO {
	private Long userId;
	private String name;
	private String email;
	private String contactNo;
	private  LocalDate dob;
	private User user;
	private List<Appointment> appointment=new ArrayList<>();
	private List<Address>address=new ArrayList<>();
	private List<Order> iorder=new ArrayList<>();
	private List<Car> car=new ArrayList<>();
	public CustomerDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	/*public CustomerDTO(Long userId, String name, String email, String contactNo, LocalDate dob, List<Address> address,
			List<Appointment> appointment, List<Order> iorder, List<Car> car, User user) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.contactNo = contactNo;
		this.dob = dob;
		this.address = address;
		this.appointment = appointment;
		this.iorder = iorder;
		this.car = car;
		this.user = user;
	}*/

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

	public void setAddress(List<Address> address) {
		this.address = address;
	}

	public List<Appointment> getAppointment() {
		return appointment;
	}

	public void setAppointment(List<Appointment> appointment) {
		this.appointment = appointment;
	}

	public List<Order> getIorder() {
		return iorder;
	}

	public void setIorder(List<Order> iorder) {
		this.iorder = iorder;
	}

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

	/*@Override
	public String toString() {
		return "Customer [userId=" + userId + ", name=" + name + ", email=" + email + ", contactNo=" + contactNo
				+ ", dob=" + dob + ", address=" + address + ", appointment=" + appointment + ", iorder=" + iorder
				+ ", car=" + car + ", user=" + user + "]";
	}*/
	
	
}
