package mum.edu.webstore.service;

import mum.edu.webstore.model.Cart;
import mum.edu.webstore.model.CartItem;

public interface CartItemService {

    void addCartItem(CartItem cartItem);

    void removeCartItem(CartItem cartItem);

    void removeAllCartItems(Cart cart);

    CartItem getCartItemByProductId(int productId);
    
	CartItem getCartItemById(Long productId);
	void removeByProductId(Cart cart, long productId);

	void removeById(long cartItemId);
    

}