package mum.edu.webstore.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="OrderInfo")
public class Order {
	
	@Id @GeneratedValue
	private long id;
	
	@ManyToOne
	private Customer customer;
	private double price;
	private Date date;
	
	@ManyToOne
	private Address shippingAddress;
	
	@ManyToOne
	private Address billingAddress;
	private String phoneNumber;
	private String email;
	private OrderStatus status;
	

}
