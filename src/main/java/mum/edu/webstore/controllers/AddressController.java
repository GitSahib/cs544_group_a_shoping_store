package mum.edu.webstore.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import mum.edu.webstore.model.City;
import mum.edu.webstore.model.SimpleCity;
import mum.edu.webstore.model.SimpleState;
import mum.edu.webstore.model.State;
import mum.edu.webstore.service.AddressService;

@Controller
public class AddressController {
	
	@Autowired
	AddressService addressService;
	
	@RequestMapping(value="/address/states/{country_id}")
	@ResponseBody
	public List<SimpleState> getStates(@PathVariable long country_id) {
		List<State> states = addressService.getStates(country_id);
		List<SimpleState> result = new ArrayList<SimpleState>();
		for(State state : states) {
			SimpleState s = new SimpleState();
			s.setId(state.getId());
			s.setName(state.getName());
			result.add(s);
		}
		return result;
	}
	
	@RequestMapping(value="/address/cities/{state_code}")
	@ResponseBody
	public List<SimpleCity> getCities(@PathVariable String state_code) {
		List<City> cities = addressService.getCities(state_code);
		List<SimpleCity> result = new ArrayList<SimpleCity>();
		for(City city : cities) {
			SimpleCity s = new SimpleCity();
			s.setId(city.getId());
			s.setName(city.getName());
			result.add(s);
		}
		return result;
	}
}
