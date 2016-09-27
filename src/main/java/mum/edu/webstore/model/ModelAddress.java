package mum.edu.webstore.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
@MappedSuperclass
public abstract class ModelAddress {
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Id
	protected String code;
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
