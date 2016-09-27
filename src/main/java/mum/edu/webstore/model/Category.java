package mum.edu.webstore.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="category")
public class Category extends Model {
	private String name;
	private String description;
	private String imageUrl;
	@OneToMany(mappedBy="category")
	private List<Product> products;
	//region -Getters and Setters
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	//endregion
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String json = "{Id:"+this.getId()+
						",CreatedTime:"+this.getUpdatedTime()+
						",Name:"+this.getName()+
						",Description:"+this.getDescription()+
						",ImageUrl:"+this.getImageUrl()+
						"}";
		return json;
	}
}
