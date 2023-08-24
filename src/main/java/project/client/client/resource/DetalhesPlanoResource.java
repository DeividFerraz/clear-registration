package project.client.client.resource;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import project.client.client.entities.DetalhesPlano;
import project.client.client.services.DetalhesPlanoServices;

@RestController
@RequestMapping(value = "/details")
public class DetalhesPlanoResource {
	
	@Autowired
	private DetalhesPlanoServices service;

	
	@GetMapping
	public ResponseEntity<List<DetalhesPlano>> findAll(){
		List<DetalhesPlano> list = service.findAll();
		return ResponseEntity.ok().body(list);
		
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<DetalhesPlano> findById(@PathVariable Long id) {
		DetalhesPlano obj = service.findById(id);
	    return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<DetalhesPlano> insert(@RequestBody DetalhesPlano obj) {
	    obj = service.insert(obj);
	    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getLog()).toUri();
	    return ResponseEntity.created(uri).body(obj);
	}
}
