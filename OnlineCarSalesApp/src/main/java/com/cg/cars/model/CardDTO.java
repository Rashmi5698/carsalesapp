package com.cg.cars.model;

import org.springframework.stereotype.Component;
import java.time.LocalDate;

@Component
public class CardDTO {

	private String cardName;
	private long cardNumber;
	private LocalDate cardExpiry;
	private Integer cvv;

	public CardDTO() {
		super();

	}

	public String getCardName() {
		return cardName;
	}

	public void setCardName(String cardName) {
		this.cardName = cardName;
	}

	public long getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(long cardNumber) {
		this.cardNumber = cardNumber;
	}

	public LocalDate getCardExpiry() {
		return cardExpiry;
	}

	public void setCardExpiry(LocalDate cardExpiry) {
		this.cardExpiry = cardExpiry;
	}

	public Integer getCvv() {
		return cvv;
	}

	public void setCvv(Integer cvv) {
		this.cvv = cvv;
	}

}
