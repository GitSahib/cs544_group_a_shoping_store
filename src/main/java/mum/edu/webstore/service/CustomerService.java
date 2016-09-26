package mum.edu.webstore.service;

import mum.edu.webstore.model.Customer;
import mum.edu.webstore.model.User;

public interface CustomerService {
    void save(Customer customer);
    Customer findByName(String name);
    User getUser(Customer customerForm);
}
