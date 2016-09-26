package mum.edu.webstore.service;

import mum.edu.webstore.model.Customer;
import mum.edu.webstore.model.Role;
import mum.edu.webstore.model.User;
import mum.edu.webstore.repository.CustomerRepository;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    public void setCustomerRepository(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}
    @Autowired
    private RoleService roleService;
    @Override
    public void save(Customer customerForm) 
    {
    	customerRepository.save(customerForm);
    }
    @Override
    public User getUser(Customer customerForm)
    {
    	User user = new User();
        Role role = roleService.findRoleByName("Customer");
        HashSet<Role> roles = new HashSet<Role>();
        roles.add(role);
        user.setRoles(roles);
        user.setUsername(customerForm.getEmail());
        user.setPassword(customerForm.getPassword());
        user.setPasswordConfirm(customerForm.getPasswordConfirm());
        return user;
    }
    @Override
    public Customer findByName(String name) {
        return customerRepository.findByFirstName(name);
    }
}
