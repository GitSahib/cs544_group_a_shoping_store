package mum.edu.webstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mum.edu.webstore.model.State;


public interface StateRepository extends JpaRepository<State, Long> {

	State findByName(String name);

	

}
