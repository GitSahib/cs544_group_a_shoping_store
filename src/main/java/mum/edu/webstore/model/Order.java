
package mum.edu.webstore.model;

import java.sql.Timestamp;
import java.util.Iterator;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.Valid;

@Entity
@Table(name = "order_line")
public class Order extends Model {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ManyToOne
	private Customer customer;
	@Embedded
	@Valid
	private SimpleAddress shippingAddress;
	@Enumerated(EnumType.STRING)
	private PaymentType paymentType;
	private Timestamp orderDate;
	private double total;
	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
	private Set<OrderItem> orderItems;
	private boolean paid;
	
	@Transient
	private String empty;		//Placeholder, used in view, but no meaning.
	
	public String getEmpty() {
		return empty;
	}
	public void setEmpty(String empty) {
		this.empty = empty;
	}
	public Set<OrderItem> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(Set<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}
	//region -Getters and Setters 
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public SimpleAddress getShippingAddress() {
		return shippingAddress;
	}
	public void setShippingAddress(SimpleAddress shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	public PaymentType getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(PaymentType paymentType) {
		this.paymentType = paymentType;
	}
	
	public Timestamp getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Timestamp date) {
		this.orderDate = date;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public String getProductSummary() {
		String summary = "";
		Iterator<OrderItem> it = orderItems.iterator();
		OrderItem item = null;
		while(it.hasNext()) {
			item = it.next();
			summary += item.getProduct().getName();
			summary += " x ";
			summary += item.getQuantity();
			summary += "<br/>";
		}
		return summary;
	}
	//endregion
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String json = "{Id:"+this.getId()+
						",Customer:"+this.getCustomer()+
						",ShippingAddress:"+this.getShippingAddress()+
						",PaymentType:"+this.getPaymentType()+
						",OrderDate:"+this.getOrderDate()+
						",Total:"+this.getTotal()+
						"}";
		return json;
	}
	public boolean isPaid() {
		return paid;
	}
	public void setPaid(boolean paid) {
		this.paid = paid;
	}
}

