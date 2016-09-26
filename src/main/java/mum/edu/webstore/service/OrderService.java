package mum.edu.webstore.service;

import java.util.List;

import mum.edu.webstore.model.Order;

public interface OrderService {
    void save(Order order);
    List<Order> getAll();
    public Order get(long id);
}
