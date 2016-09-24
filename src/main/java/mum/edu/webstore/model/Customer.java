package mum.edu.webstore.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer extends Model {
	private String firstName;
	private String lastName;
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="address_customers",
         joinColumns=
         @JoinColumn(name="customer_id", referencedColumnName="customer_id"),
         inverseJoinColumns=
         @JoinColumn(name="address_id", referencedColumnName="address_id")
    )
	private List<Address> addressList;
	private String email;
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public List<Address> getAddressList() {
		return addressList;
	}
	public void setAddressList(List<Address> addressList) {
		this.addressList = addressList;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
