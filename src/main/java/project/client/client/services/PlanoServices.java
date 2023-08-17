package project.client.client.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import project.client.client.entities.PlanoMovel;
import project.client.client.repositories.PlanoRepository;
import project.client.client.services.exceptions.DataBaseException;
import project.client.client.services.exceptions.ResourceNotFoundException;

@Service
public class PlanoServices {

	@Autowired
	private PlanoRepository repository;
	
	public List<PlanoMovel> findAll(){
		return repository.findAll();
	}
	
	public PlanoMovel findById(Long id) {
	    Optional<PlanoMovel> obj = repository.findById(id);
	    return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public PlanoMovel insert(PlanoMovel obj) {//Inserir obj no banco
		return repository.save(obj);
	}
	
	//tem o metodo delete ainda
	public void delete(Long id) {//Quando for add um endPoint
		//precisa mexer na classe service e resource
		try {
			repository.deleteById(id);
		}catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataBaseException(e.getMessage());
		}
	}
}
