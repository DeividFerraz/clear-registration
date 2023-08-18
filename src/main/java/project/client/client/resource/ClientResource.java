package project.client.client.resource;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import project.client.client.entities.ClientLog;
import project.client.client.services.ClientServices;

@RestController
@RequestMapping(value = "/clients")
public class ClientResource {
	
	@Autowired
	private ClientServices service;
	@Autowired
	private ClientServices serviceId;
	
	@GetMapping
	public ResponseEntity<List<ClientLog>> findAll(){
		List<ClientLog> list = service.findAll();
		return ResponseEntity.ok().body(list);
		
	}
	
	@GetMapping(value = "/cpf/{cpf}")
	public ResponseEntity<ClientLog> findByCpf(@PathVariable String cpf) {
	    ClientLog obj = service.findByCpf(cpf);
	    return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping(value = "/id/{id}")
	public ResponseEntity<ClientLog> findById(@PathVariable Long id) {
		ClientLog obj = serviceId.findById(id);
	    return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<ClientLog> insert(@RequestBody ClientLog obj){//inserir obj no banco
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	//tem o delete ainda
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<ClientLog> update(@PathVariable Long id,
			@RequestBody ClientLog obj) {
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
}
