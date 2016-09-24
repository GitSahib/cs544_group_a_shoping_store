package mum.edu.webstore.repository;

import org.springframework.data.repository.CrudRepository;

import mum.edu.webstore.model.Product;
public interface ProductRepository extends CrudRepository<Product, Long> {
    Product findByName(String name);
}
