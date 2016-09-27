package mum.edu.webstore.service;

import java.util.List;

import mum.edu.webstore.model.Category;

public interface CategoryService {
    void save(Category category);

    Category findByName(String name);
    List<Category> getAll();
    void add(Category category);
    void delete(long id);
    Category get(long id);
    void update(long id,Category category);
}
