package mum.edu.webstore.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Cart {
	
	private List<CartItem> items = new ArrayList<CartItem>();

	public List<CartItem> getItems() {
		return items;
	}

	public void setItems(List<CartItem> items) {
		this.items = items;
	}

	public void addItem(Product p, int quantity) {
		CartItem item = new CartItem();
		item.setProduct(p);
		item.setQuantity(quantity);
		items.add(item);
		}
	
	public boolean getIsEmpty() {
		return items.isEmpty();
	}
	
	public double getTotalPrice() {
		double totalPrice = 0;
		Iterator<CartItem> it = items.iterator();
		while(it.hasNext()) {
			CartItem item = it.next();
			totalPrice += item.getProduct().getPrice() * item.getQuantity();
		}
		return totalPrice;
	}

}
