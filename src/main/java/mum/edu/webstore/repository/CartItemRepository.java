package mum.edu.webstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import mum.edu.webstore.model.CartItem;
@Transactional(readOnly = true)
public interface CartItemRepository extends JpaRepository<CartItem, Long>{   

    CartItem getByProductId(int productId);
    @Modifying
    @Transactional
    @Query("delete from CartItem ci where ci.cart.id = ?1")
    void deleteAllByCartId(Long cartId);
    @Modifying
    @Transactional
    @Query("delete from CartItem ci where ci.product.id =?1 And ci.cart.id = ?2")
	void removeProductFromCart(Long productId, Long id);
    @Modifying
    @Transactional
    @Query("delete from CartItem ci where id = ?1")
	void removeById(long cartItemId);
}