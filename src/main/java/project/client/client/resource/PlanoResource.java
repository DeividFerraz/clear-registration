package project.client.client.resource;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import project.client.client.entities.PlanoMovel;
import project.client.client.services.PlanoServices;

@RestController
@RequestMapping(value = "/flats")
public class PlanoResource {
	
	@Autowired
	private PlanoServices service;
	
	@GetMapping
	public ResponseEntity<List<PlanoMovel>> findAll(){
		List<PlanoMovel> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<PlanoMovel> findById(@PathVariable Long id) {
		PlanoMovel obj = service.findById(id);
	    return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<PlanoMovel> insert(@RequestBody PlanoMovel obj){//inserir obj no banco
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();// o noContent retorna o 204
	}
}
