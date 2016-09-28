package mum.edu.webstore.service;

import java.util.List;

import mum.edu.webstore.model.State;

public interface StateService {
    void save(State role);
    State findStateByName(String name);
    List<State> getAll();
}
