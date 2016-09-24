package mum.edu.webstore.service;

import mum.edu.webstore.model.Role;
import mum.edu.webstore.model.User;
import mum.edu.webstore.repository.RoleRepository;
import mum.edu.webstore.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	public void setRoleRepository(RoleRepository roleRepository) {
		this.roleRepository = roleRepository;
	}	
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        //user.setRoles(new HashSet<>(roleRepository.findAll()));
        userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

	@Override
	public Role findRoleByName(String name) {
		// TODO Auto-generated method stub
		return roleRepository.findByName(name);
	}
}
