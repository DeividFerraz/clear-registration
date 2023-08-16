package project.client.client.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import project.client.client.entities.ClientLog;
import project.client.client.services.ClientServices;

@RestController
@RequestMapping(value = "/clients")
public class ClientResource {
	
	@Autowired
	private ClientServices service;
	
	@GetMapping
	public ResponseEntity<List<ClientLog>> findAll(){
		List<ClientLog> list = service.findAll();
		return ResponseEntity.ok().body(list);
		
	}

}
