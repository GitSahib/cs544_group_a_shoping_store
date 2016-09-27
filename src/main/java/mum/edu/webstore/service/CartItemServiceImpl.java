package mum.edu.webstore.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mum.edu.webstore.model.Cart;
import mum.edu.webstore.model.CartItem;
import mum.edu.webstore.repository.CartItemRepository;
@Transactional
@Service
public class CartItemServiceImpl implements CartItemService{

    @Autowired
    private CartItemRepository cartItemDao;

	@Override
	public void addCartItem(CartItem cartItem) {
		// TODO Auto-generated method stub
		cartItemDao.save(cartItem);
	}

	@Override
	public void removeCartItem(CartItem cartItem) {
		// TODO Auto-generated method stub
		cartItemDao.delete(cartItem);
	}

	@Override
	public void removeAllCartItems(Cart cart) {
		// TODO Auto-generated method stub
		
		cartItemDao.deleteAllByCartId(cart.getId());
		cartItemDao.flush();
	}

	@Override
	public CartItem getCartItemByProductId(int productId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CartItem getCartItemById(Long cartItemId) {
		// TODO Auto-generated method stub
		return cartItemDao.findOne(cartItemId);
	}
	@Override
	public void removeByProductId(Cart cart, long productId) {
		// TODO Auto-generated method stub
		cartItemDao.removeProductFromCart(productId,cart.getId());
	}

	@Override
	public void removeById(long cartItemId) {
		// TODO Auto-generated method stub
		cartItemDao.removeById(cartItemId);
	}

} // The End of Class;