package com.cg.cars.entities;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
@Entity
@Table(name="Payment")
//@OnDelete(action=OnDeleteAction.NO_ACTION)
public class Payment {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="PAYMENT_ID")
	private Long paymentId;
	
	@Column(name="TYPE")
	private String type;
	@Column(name="STATUS")
	private String status;
	@OneToMany(cascade= {CascadeType.ALL,CascadeType.DETACH,CascadeType.REFRESH})
	@JoinTable(
			name = "PAYMENT_CARD",
			joinColumns = { @JoinColumn(name = "PAYMENT_ID")},
		inverseJoinColumns = { @JoinColumn(name = "CARD_ID")})
	private List<Card> card=new ArrayList<>();
	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}
	/*public Payment(Long paymentId, String type, String status, List<Card> card) {
		super();
		this.paymentId = paymentId;
		this.type = type;
		this.status = status;
		this.card = card;
	}*/
	public Long getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(Long paymentId) {
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
	/*@Override
	public String toString() {
		return "Payment [paymentId=" + paymentId + ", type=" + type + ", status=" + status + ", card=" + card + "]";
	}	*/
}
