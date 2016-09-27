<<<<<<< HEAD
package mum.edu.webstore.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name="stock")
public class Stock extends Model {
	@OneToOne(optional=false)
    @JoinColumn(name = "product_id") 
    private Product product; 
	int quantity;
	//region -Getters and Setters
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	//endregion
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String json = "{Id:"+this.getId()+
						",CreatedTime:"+this.getUpdatedTime()+
						",Product:"+this.getProduct()+
						",Quantity:"+this.getQuantity()+
						"}";
		return json;
	}
}
=======
package mum.edu.webstore.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name="stock")
public class Stock extends Model {
	@OneToOne(optional=true)
    @JoinColumn(name = "product_id") 
    private Product product; 
	int quantity;
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
>>>>>>> origin
