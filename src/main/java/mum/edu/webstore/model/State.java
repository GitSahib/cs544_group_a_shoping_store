package mum.edu.webstore.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="state")
public class State extends ModelAddress{
	
	private String name;
	//region -Getters and Setters
	@OneToMany(mappedBy="state")
	private List<City> cities;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<City> getCities() {
		return cities;
	}

	public void setCities(List<City> cities) {
		this.cities = cities;
	}
	//endregion
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String json = "{Id:"+this.getId()+
						",Code:"+this.getCode()+
						",Name:"+this.getName()+
						"}";
		return json;
	}
	
}
