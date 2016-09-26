package mum.edu.webstore.service;

import mum.edu.webstore.model.Role;
import mum.edu.webstore.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;
    public void setRoleRepository(RoleRepository roleRepository) {
		this.roleRepository = roleRepository;
	}
    
	@Override
	public Role findRoleByName(String name) {
		// TODO Auto-generated method stub
		return roleRepository.findByName(name);
	}

	@Override
	public void save(Role role) {
		// TODO Auto-generated method stub
		roleRepository.save(role);
	}
}
