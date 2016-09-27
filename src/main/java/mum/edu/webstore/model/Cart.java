package mum.edu.webstore.model;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Cart extends Model{

    private static final long serialVersionUID = 3940548625296145582L;
    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<CartItem> cartItems;
    @OneToOne
    @JoinColumn(name = "customer_id")
    @JsonIgnore
    private Customer customer;

    private double grandTotal;

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public double getGrandTotal() {
    	grandTotal = 0;
        for(CartItem item:cartItems)
        {
        	grandTotal += item.getTotalPrice();
        }
    	return grandTotal;
    }

    public void setGrandTotal(double grandTotal) {
        this.grandTotal = grandTotal;
    }

} // The End of Class;