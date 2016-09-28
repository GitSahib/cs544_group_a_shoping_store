package mum.edu.webstore.service;

import mum.edu.webstore.model.State;
import mum.edu.webstore.repository.StateRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StateServiceImpl implements StateService {
    @Autowired
    private StateRepository stateRepository;
     
	@Override
	public State findStateByName(String name) {
		// TODO Auto-generated method stub
		return stateRepository.findByName(name);
	}

	@Override
	public void save(State state) {
		// TODO Auto-generated method stub
		stateRepository.save(state);
	}

	@Override
	public List<State> getAll() {
		// TODO Auto-generated method stub
		return stateRepository.findAll();
	}
}
