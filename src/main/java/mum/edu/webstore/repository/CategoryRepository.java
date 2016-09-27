package mum.edu.webstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mum.edu.webstore.model.Category;


public interface CategoryRepository extends JpaRepository<Category, Long> {
	Category findByName(String name);
}
