package mum.edu.webstore.service;

import mum.edu.webstore.model.Cart;

public interface CartService {

    Cart getCartById(long cartId);
    void save(Cart cart);
    void update(Cart cart);
	
}