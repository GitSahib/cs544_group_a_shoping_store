package mum.edu.webstore.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mum.edu.webstore.model.Cart;
import mum.edu.webstore.repository.CartRepository;

@Transactional
@Service
public class CartServiceImpl implements CartService{

    @Autowired
    private CartRepository cartDao;
    
	@Override
	public Cart getCartById(long cartId) {
		// TODO Auto-generated method stub
		return cartDao.getCartById(cartId);
	}

	@Override
	public void update(Cart cart) {
		// TODO Auto-generated method stub
		cartDao.save(cart);
	}

	@Override
	public void save(Cart cart) {
		// TODO Auto-generated method stub
		cartDao.save(cart);
	}

	

} // The End of Class;