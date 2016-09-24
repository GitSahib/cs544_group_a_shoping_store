package mum.edu.webstore.model;

import java.sql.Timestamp;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
@MappedSuperclass
public abstract class Model {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Long id;
	protected Timestamp updatedTime;
	protected Timestamp getUpdatedTime() {
		return updatedTime;
	}
	public void setUpdatedTime(Timestamp updatedTime) {
		this.updatedTime = updatedTime;
	}
	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}