package mum.edu.webstore.model;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name="product")
public class Product extends Model{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ManyToOne
	private Category category;
	private String name;
	private String description;
	private String imageUrl;
	private double price;
	@OneToOne(optional=false,cascade=CascadeType.ALL, 
		       mappedBy="product",targetEntity=Stock.class)
	private Stock stock;
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
	private Set<OrderItem> orderItems;
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    private List<CartItem> cartItemList;
	//region -Getters and Setters
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
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
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Stock getStock() {
		return stock;
	}
	public void setStock(Stock stock) {
		this.stock = stock;
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
						",Price:"+this.getPrice()+
						",Stock:"+this.getStock()+
						"}";
		return json;
	}
}
