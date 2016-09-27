package mum.edu.webstore.model;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
@MappedSuperclass
public abstract class Model implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Model()
	{
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Long id;
	@Column(columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	protected Date updatedTime;
	protected Date getUpdatedTime() {
		return updatedTime;
	}
	public void setUpdatedTime(Date updatedTime) {
		this.updatedTime = updatedTime;
	}
	public Long getId() {
        return id;
    }
	
    public void setId(Long id) {
        this.id = id;
    }
}
