package com.cg.cars.model;

import java.time.LocalDate;
import java.time.LocalTime;
import org.springframework.stereotype.Component;
import com.cg.cars.entities.Payment;

@Component
public class AppointmentDTO {

	private Long appointmentId;
	private String location;
	private String inspectionType;
	private LocalDate preferredDate;
	private LocalTime preferredTime;
	private Payment payment;

	public AppointmentDTO() {
		super();

	}

	public Long getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(Long appointmentId) {
		this.appointmentId = appointmentId;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getInspectionType() {
		return inspectionType;
	}

	public void setInspectionType(String inspectionType) {
		this.inspectionType = inspectionType;
	}

	public LocalDate getPreferredDate() {
		return preferredDate;
	}

	public void setPreferredDate(LocalDate preferredDate) {
		this.preferredDate = preferredDate;
	}

	public LocalTime getPreferredTime() {
		return preferredTime;
	}

	public void setPreferredTime(LocalTime preferredTime) {
		this.preferredTime = preferredTime;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

}
