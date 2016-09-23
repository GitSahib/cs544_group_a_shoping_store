package mum.edu.webstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mum.edu.webstore.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
}
