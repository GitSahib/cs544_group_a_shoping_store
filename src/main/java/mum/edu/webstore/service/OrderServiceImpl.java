package mum.edu.webstore.service;

import mum.edu.webstore.model.Order;
import mum.edu.webstore.repository.OrderRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;


    @Override
    public void save(Order order) {
    	orderRepository.save(order);
    }
    
    @Override
    public List<Order> getAll(){
    	return orderRepository.findAll();
    }
    
	@Override
	public Order get(long id) {
		// TODO Auto-generated method stub
		return orderRepository.findOne(id);
	}

}
