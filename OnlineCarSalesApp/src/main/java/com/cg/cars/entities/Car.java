package com.cg.cars.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "car")
public class Car {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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

	public Car() {
		super();
	}

}
