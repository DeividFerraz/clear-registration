package project.client.client.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
