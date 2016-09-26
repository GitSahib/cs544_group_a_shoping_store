package mum.edu.webstore.model;

public class CartItem {
	
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
	private Product product;
	private int quantity;
	
	
	public double getSubTotal() {
		return product.getPrice() * quantity;
	}

}
