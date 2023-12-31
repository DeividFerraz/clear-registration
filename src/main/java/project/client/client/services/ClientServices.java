package project.client.client.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import project.client.client.entities.ClientLog;
import project.client.client.repositories.ClientRepository;
import project.client.client.services.exceptions.ResourceNotFoundException;

@Service
public class ClientServices {

	@Autowired
	private ClientRepository repository;
	@Autowired
	private ClientRepository repositoryId;
	
	public List<ClientLog> findAll(){
		return repository.findAll();
	}
	
	public ClientLog findByCpf(String cpf) {
	    Optional<ClientLog> obj = repository.findByCpf(cpf);
	    return obj.orElseThrow(() -> new ResourceNotFoundException(cpf));
	}
	
	public ClientLog findById(Long id) {
	    Optional<ClientLog> obj = repositoryId.findById(id);
	    /*orElseThrow é um metodo da interface optional, ele serve para ver se ah ou não um objeto 
	     * na classe q foi declarada dento do optional, caso m haja ele lanca uma exceção*/
	    return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public ClientLog insert(ClientLog obj) {//Inserir obj no banco
		return repository.save(obj);
	}
	
	public boolean existsByCpf(String cpf) {
	    return repository.existsByCpf(cpf);
	}

	
	//tem o metodo delete ainda
	
	public ClientLog update(Long id, ClientLog obj) {
		try {
			ClientLog entity = repository.getReferenceById(id);
			updateData(entity, obj);
			return repository.save(entity);
		} catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}
	//metodo para atualizar
	private void updateData(ClientLog entity, ClientLog obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
		entity.setFlat(obj.getFlat());
		entity.setCpf(obj.getCpf());
	}
}
