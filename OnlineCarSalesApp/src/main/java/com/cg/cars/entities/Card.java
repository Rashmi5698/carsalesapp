package com.cg.cars.entities;

import java.time.LocalDate;
import javax.persistence.*;
@Entity
@Table(name="Card")
public class Card {
	@Id
	private String cardName;
	@Column
	private String cardNumber;
    private LocalDate cardExpiry;
    private int cvv;
	public Card(String cardName, String cardNumber, LocalDate cardExpiry, int cvv) {
		super();
		this.cardName = cardName;
		this.cardNumber = cardNumber;
		this.cardExpiry = cardExpiry;
		this.cvv = cvv;
	}
	public Card() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getCardName() {
		return cardName;
	}
	public void setCardName(String cardName) {
		this.cardName = cardName;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public LocalDate getCardExpiry() {
		return cardExpiry;
	}
	public void setCardExpiry(LocalDate cardExpiry) {
		this.cardExpiry = cardExpiry;
	}
	public int getCvv() {
		return cvv;
	}
	public void setCvv(int cvv) {
		this.cvv = cvv;
	}
	@Override
	public String toString() {
		return "Card [cardName=" + cardName + ", cardNumber=" + cardNumber + ", cardExpiry=" + cardExpiry + ", cvv="
				+ cvv + "]";
	}
    
}
