package mum.edu.webstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mum.edu.webstore.model.Country;


public interface CountryRepository extends JpaRepository<Country, Long> {


}
