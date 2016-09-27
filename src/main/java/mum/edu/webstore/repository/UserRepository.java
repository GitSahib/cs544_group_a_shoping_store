package mum.edu.webstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mum.edu.webstore.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

	
}
