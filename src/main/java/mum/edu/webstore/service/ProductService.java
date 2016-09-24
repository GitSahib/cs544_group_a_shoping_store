package mum.edu.webstore.service;

import java.util.List;

import mum.edu.webstore.model.Product;

public interface ProductService {
    void save(Product prouduct);

    Product findByName(String name);
    List<Product> getAll();
    void add(Product product);
    void delete(long id);
    Product get(long id);
    void update(long id,Product product);
}
