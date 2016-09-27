package mum.edu.webstore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import mum.edu.webstore.model.Country;
import mum.edu.webstore.model.State;


public interface StateRepository extends JpaRepository<State, Long> {

	

}
