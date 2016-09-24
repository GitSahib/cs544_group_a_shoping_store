package mum.edu.webstore.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "order")
public class Order extends Model {
	@ManyToOne
	private Customer customer;
	@ManyToOne
	private Address shippingAddress;
	@Enumerated(EnumType.STRING)
	private PaymentType paymentType;
	private Timestamp date;
	private double total;
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="order_detail",
         joinColumns=
         @JoinColumn(name="order_id", referencedColumnName="order_id"),
         inverseJoinColumns=
         @JoinColumn(name="product_id", referencedColumnName="product_id")
    )
    private List<Product> productList;
	 
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Address getShippingAddress() {
		return shippingAddress;
	}
	public void setShippingAddress(Address shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	public PaymentType getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(PaymentType paymentType) {
		this.paymentType = paymentType;
	}
	
	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
}
