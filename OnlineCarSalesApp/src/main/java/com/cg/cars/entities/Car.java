package com.cg.cars.entities;
import javax.persistence.*;
import java.time.LocalDate;
@Entity
@Table(name="car")
public class Car {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long carId;
	@Column
	private String brand;
	private String model;
	private String variant;
	private LocalDate registrationYear;
	private String registrationState;
	public Long getCarId() {
		return carId;
	}
	public void setCarId(Long carId) {
		this.carId = carId;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getVariant() {
		return variant;
	}
	public void setVariant(String variant) {
		this.variant = variant;
	}
	public LocalDate getRegistrationYear() {
		return registrationYear;
	}
	public void setRegistrationYear(LocalDate registrationYear) {
		this.registrationYear = registrationYear;
	}
	public String getRegistrationState() {
		return registrationState;
	}
	public void setRegistrationState(String registrationState) {
		this.registrationState = registrationState;
	}
	public Car(Long carId, String brand, String model, String variant, LocalDate registrationYear,
			String registrationState) {
		super();
		this.carId = carId;
		this.brand = brand;
		this.model = model;
		this.variant = variant;
		this.registrationYear = registrationYear;
		this.registrationState = registrationState;
	}
	public Car() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Car [carId=" + carId + ", brand=" + brand + ", model=" + model + ", variant=" + variant
				+ ", registrationYear=" + registrationYear + ", registrationState=" + registrationState + "]";
	}
}
