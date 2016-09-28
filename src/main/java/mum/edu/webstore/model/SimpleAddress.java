package mum.edu.webstore.model;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

@Embeddable
public class SimpleAddress {
	
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
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
	@NotNull
	@Length(min=3, max=200, message="Address must be at least 3 characters long and not more than 200 characters" )
	private String street;
	
	
	private String country;
	
	private String state;
	private String city;
	
	@Pattern(message="Must be digits" , regexp="[0-9]+")
	private String zip;

}
