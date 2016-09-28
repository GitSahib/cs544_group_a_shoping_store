package mum.edu.webstore.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "order_detail")
public class OrderItem implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Order order;
    private Product product;
    private int quantity;
    //region -Getters and Setters
    @Id
    @ManyToOne
    @JoinColumn(name = "product_id")
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	@Id
    @ManyToOne
    @JoinColumn(name = "order_id")
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
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
		String json = "{Order:"+this.getOrder()+
						",Product:"+this.getProduct()+
						",Quantity:"+this.getQuantity()+
						"}";
		return json;
	}
	
	@Transient
	public double getTotal() {
		return quantity * product.getPrice();
	}
}
