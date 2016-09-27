package mum.edu.webstore.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity 
@Table(name="country")
public class Country extends Model{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	@OneToMany
	private List<State> states;
	//region Getters and Setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<State> getStates() {
		return states;
	}

	public void setStates(List<State> states) {
		this.states = states;
	}
	//endregion
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String json = "{Id:"+this.getId()+
						",CreatedTime:"+this.getUpdatedTime()+
						",Name:"+this.getName()+
						"}";
		return json;
	}
}
