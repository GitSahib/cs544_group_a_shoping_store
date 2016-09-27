package mum.edu.webstore.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="city")
public class City extends Model {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	@ManyToOne
	private State state;
	@OneToMany(mappedBy="city")
	private List<Address> addresses;
	
	//region -Getters and Setters
	public List<Address> getAddresses() {
		return addresses;
	}
	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	//endregion
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String json = "{Id:"+this.getId()+
						",Name:"+this.getName()+
						",State:"+this.getState()+
						"}";
		return json;
	}
	
}
