package project.client.client.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.client.client.entities.DetalhesPlano;
import project.client.client.repositories.DetalhesPlanoRepository;
import project.client.client.services.exceptions.ResourceNotFoundException;

@Service
public class DetalhesPlanoServices {

	@Autowired
	private DetalhesPlanoRepository repository;
	
	public List<DetalhesPlano> findAll(){
		return repository.findAll();
	}
	
	public DetalhesPlano findById(Long id) {
	    Optional<DetalhesPlano> obj = repository.findById(id);
	    return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public DetalhesPlano insert(DetalhesPlano obj) {//Inserir obj no banco
		return repository.save(obj);
	}
}
