package mum.edu.webstore.service;

import mum.edu.webstore.model.Contact;

public interface ContactService {
	Contact findByName(String name);
	Contact findByEmail(String email);
	Contact findBySubject(String subject);
	Contact findById(Long id);
	void save(Contact contact);
	void delete(Contact contact);
}
