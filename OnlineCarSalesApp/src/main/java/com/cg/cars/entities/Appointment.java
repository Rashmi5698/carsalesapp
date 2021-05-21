package com.cg.cars.entities;
import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
@Entity
@Table(name="appointment")
public class Appointment {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="APPOINTMENT_ID")
	private Long appointmentId;
	@Column(name="LOCATION")
	private String location;
	@Column(name="INSPECTION_TYPE")
	private String inspectionType;
	@Column(name="PREFERRED_DATE")
	private LocalDate preferredDate;
	@Column(name="PREFERRED_TIME")
	private LocalTime preferredTime;
	
	@OneToOne(cascade= {CascadeType.ALL,CascadeType.DETACH,CascadeType.REFRESH})
	//@OnDelete(action=OnDeleteAction.CASCADE)
	@JoinColumn(name="payment_id")
	private Payment payment;	

	public Appointment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Appointment(Long appointmentId, String location, String inspectionType, LocalDate preferredDate,
			LocalTime preferredTime, Payment payment) {
		super();
		this.appointmentId = appointmentId;
		this.location = location;
		this.inspectionType = inspectionType;
		this.preferredDate = preferredDate;
		this.preferredTime = preferredTime;
		this.payment = payment;
	
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
	
	
	@Override
	public String toString() {
		return "Appointment [appointmentId=" + appointmentId + ", location=" + location + ", inspectionType="
				+ inspectionType + ", preferredDate=" + preferredDate + ", preferredTime=" + preferredTime+",payment=" 
				+ payment +"]";
						
	}
	

}
