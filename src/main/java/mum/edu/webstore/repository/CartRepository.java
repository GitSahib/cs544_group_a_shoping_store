package mum.edu.webstore.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import mum.edu.webstore.model.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> {

    Cart getCartById(long cartId);  

}
