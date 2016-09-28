package mum.edu.webstore.service;

import java.util.List;

import mum.edu.webstore.model.City;
import mum.edu.webstore.model.Country;
import mum.edu.webstore.model.State;


public interface AddressService {
    List<Country> getAllCountries();
    List<State> getAllStates();
    List<State> getStates(long country_id);
    List<City> getCities(String state_code);
}
