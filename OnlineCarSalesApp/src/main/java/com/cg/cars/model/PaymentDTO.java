package com.cg.cars.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cg.cars.entities.Card;
@Component
public class PaymentDTO {
	
	private long paymentId;
	
	private String type;
	private String status;
	private List<Card> card=new ArrayList<>();
	public PaymentDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PaymentDTO(long paymentId, String type, String status, List<Card> card) {
		super();
		this.paymentId = paymentId;
		this.type = type;
		this.status = status;
		this.card = card;
	}
	public long getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(long paymentId) {
		this.paymentId = paymentId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public List<Card> getCard() {
		return card;
	}
	public void setCard(List<Card> card) {
		this.card = card;
	}
	@Override
	public String toString() {
		return "PaymentDTO [paymentId=" + paymentId + ", type=" + type + ", status=" + status + ", card=" + card + "]";
	}
}
