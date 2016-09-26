package mum.edu.webstore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import mum.edu.webstore.model.City;



public interface CityRepository extends JpaRepository<City, Long> {

		List<City> findByStateCode(String state_code);

}
