package mum.edu.webstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mum.edu.webstore.model.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long>{

	Contact findByName(String name);
	Contact findByEmail(String email);
	Contact findBySubject(String subject);
	Contact findById(Long id);
}
