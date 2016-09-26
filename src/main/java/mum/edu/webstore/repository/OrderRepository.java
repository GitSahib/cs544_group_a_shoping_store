package mum.edu.webstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mum.edu.webstore.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {


}
