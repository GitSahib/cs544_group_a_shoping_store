package mum.edu.webstore.service;

import mum.edu.webstore.model.Customer;

public interface CustomerService {
    void save(Customer customer);

    Customer findByName(String name);
}
