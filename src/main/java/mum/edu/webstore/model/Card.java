package mum.edu.webstore.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="card")
public class Card extends Model {
	private String cardNumber;
	@Enumerated(EnumType.STRING)
	private CardType type;	
	private int expiryYear;
	private int expiryMonth;
	private int securityNumber;
	@ManyToOne
	private Customer customer;
	//region - Getters and Setters
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public CardType getType() {
		return type;
	}
	public void setType(CardType type) {
		this.type = type;
	}
	public int getExpiryYear() {
		return expiryYear;
	}
	public void setExpiryYear(int expiryYear) {
		this.expiryYear = expiryYear;
	}
	public int getExpiryMonth() {
		return expiryMonth;
	}
	public void setExpiryMonth(int expiryMonth) {
		this.expiryMonth = expiryMonth;
	}
	public int getSecurityNumber() {
		return securityNumber;
	}
	public void setSecurityNumber(int securityNumber) {
		this.securityNumber = securityNumber;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	//endregion
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String json = "{Id:"+this.getId()+
						",CreatedTime:"+this.getUpdatedTime()+
						",CardNumber:"+this.getCardNumber()+
						",CardType:"+this.getType()+
						",ExpiryYear:"+this.getExpiryYear()+
						",ExpiryMonth:"+this.getExpiryMonth()+
						",SecurityNumber:"+this.getSecurityNumber()+
						"}";
		return json;
	}
}
