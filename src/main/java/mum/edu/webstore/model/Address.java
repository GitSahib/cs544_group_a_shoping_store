package mum.edu.webstore.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="address")
public class Address extends Model{
	private String street;
	
	@ManyToOne
	private City city;
	private String zip;
	@ManyToMany(mappedBy="addressList",fetch=FetchType.EAGER)
	private List<Customer> customerList;
	public List<Customer> getCustomerList() {
		return customerList;
	}
	public void setCustomerList(List<Customer> customerList) {
		this.customerList = customerList;
	}
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	} 
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String json = "{Id:"+this.getId()+
						",CreatedTime:"+this.getUpdatedTime()+
						",Street:"+this.getStreet()+
						",City:"+this.getCity()+
						",Zip:"+this.getZip()+
						"}";
		return json;
	}
}
