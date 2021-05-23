package com.cg.cars.model;

import org.springframework.stereotype.Component;
import java.time.LocalDate;

@Component
public class CardDTO {
	
	private String cardName;
	private long cardNumber;
    private LocalDate cardExpiry;
    private Integer cvv;
 
	/*public CardDTO(long cardNumber,String cardName, LocalDate cardExpiry, Integer cvv) {
		super();
		this.cardNumber = cardNumber;
		this.cardName = cardName;
		this.cardExpiry = cardExpiry;
		this.cvv = cvv;
		
	}*/
	public CardDTO() {
		super();
		// TODO Auto-generated constructor stub
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
	

	/*@Override
	public String toString() {
		return "Card [cardNumber=+" + cardNumber+", cardName=" + cardName + ", cardExpiry=" + cardExpiry + ", cvv="
				+ cvv + "]";
	}*/
    
}
