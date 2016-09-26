package mum.edu.webstore.service;


import mum.edu.webstore.model.City;
import mum.edu.webstore.model.Country;
import mum.edu.webstore.model.State;
import mum.edu.webstore.repository.CityRepository;
import mum.edu.webstore.repository.CountryRepository;
import mum.edu.webstore.repository.StateRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    private CountryRepository countryRepository;
    @Autowired
    private StateRepository stateRepository;
    @Autowired
    private CityRepository cityRepository;
    
    
	@Override
	public List<Country> getAllCountries() {
		return countryRepository.findAll();
	}
	@Override
	public List<State> getStates(long country_id) {
		return stateRepository.findByCountryId(country_id);
	}
	@Override
	public List<City> getCities(String state_code) {
		return cityRepository.findByStateCode(state_code);
	}
    
}
