package mum.edu.webstore.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity // Table Name customer
@Table(name = "customer")
public class Customer extends Model {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// region - Table properties
	private String firstName;
	private String lastName;
	private String phoneNumber;
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "address_customers", joinColumns = @JoinColumn(name = "customer_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "address_id", referencedColumnName = "id"))
	private List<Address> addressList;
	@OneToMany(mappedBy = "customer")
	private List<Card> cardList;
	private String email;
	@OneToMany(mappedBy = "customer")
	private List<Order> orderList;
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	User user;
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinColumn(name = "cartId")
    @JsonIgnore
    private Cart cart;
	// endregion
	// region - Transient Customer Form fields
	@Transient
	private String password;
	@Transient
	private String passwordConfirm;
	@Transient
	private String street;
	@Transient
	private String state;
	@Transient
	private String city;
	@Transient
	private String username;
	

	// endregion
	// region - Getters and Setters
	public List<Order> getOrderList() {
		return orderList;
	}
	
	public void setOrderList(List<Order> orderList) {
		this.orderList = orderList;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public List<Address> getAddressList() {
		return addressList;
	}

	public void setAddressList(List<Address> addressList) {
		this.addressList = addressList;
	}

	public List<Card> getCardList() {
		return cardList;
	}

	public void setCardList(List<Card> cardList) {
		this.cardList = cardList;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}
	public String getUsername() {
		return username;
	}
	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	// endregion;
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String json = "{Id:" + this.getId() + ",CreatedTime:" + this.getUpdatedTime() + ",FirstName:" + 
		this.getFirstName()+",LastName:"+this.getLastName()+",PhoneNumber:"+this.getPhoneNumber()+
		",Email:" + this.getEmail() + "}";
		return json;
	}
}
