package mum.edu.webstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mum.edu.webstore.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findByFirstName(String name);
    Customer findByLastName(String name);
    Customer findByEmail(String email);
}
