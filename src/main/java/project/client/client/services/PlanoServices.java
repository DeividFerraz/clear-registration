package project.client.client.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.client.client.entities.PlanoMovel;
import project.client.client.repositories.PlanoRepository;

@Service
public class PlanoServices {

	@Autowired
	private PlanoRepository repository;
	
	public List<PlanoMovel> findAll(){
		return repository.findAll();
	}
}
