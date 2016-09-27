package mum.edu.webstore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import mum.edu.webstore.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

	List<Order> findAllByCustomerId(long customer_id);

}
