package mum.edu.webstore.service;

import mum.edu.webstore.model.Product;
import mum.edu.webstore.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Override
    public void save(Product product) {
    	productRepository.save(product);
    }

    @Override
    public Product findByName(String name) {
        return productRepository.findByName(name);
    }

	@Override
	public List<Product> getAll() {
		// TODO Auto-generated method stub
		return (List<Product>) productRepository.findAll();
	}

	@Override
	public void add(Product product) {
		// TODO Auto-generated method stub
		productRepository.save(product);
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		productRepository.delete(id);
	}

	@Override
	public Product get(long id) {
		// TODO Auto-generated method stub
		return productRepository.findOne(id);
	}

	@Override
	public void update(long id,Product product) {
		// TODO Auto-generated method stub
		productRepository.save(product);
	}
}
