package project.client.client.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.client.client.entities.ClientLog;
import project.client.client.repositories.ClientRepository;

@Service
public class ClientServices {

	@Autowired
	private ClientRepository repository;
	
	public List<ClientLog> findAll(){
		return repository.findAll();
	}
}
