package mum.edu.webstore.service;

import mum.edu.webstore.model.Category;
import mum.edu.webstore.model.Product;
import mum.edu.webstore.repository.CategoryRepository;
import mum.edu.webstore.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public void save(Category category) {
    	categoryRepository.save(category);
    }

    @Override
    public Category findByName(String name) {
        return categoryRepository.findByName(name);
    }

	@Override
	public List<Category> getAll() {
		// TODO Auto-generated method stub
		return (List<Category>) categoryRepository.findAll();
	}

	@Override
	public void add(Category category) {
		// TODO Auto-generated method stub
		categoryRepository.save(category);
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		categoryRepository.delete(id);
	}

	@Override
	public Category get(long id) {
		// TODO Auto-generated method stub
		return categoryRepository.findOne(id);
	}

	@Override
	public void update(long id,Category category) {
		// TODO Auto-generated method stub
		categoryRepository.save(category);
	}
}
