package com.example.demoPOEC.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demoPOEC.model.Client;
import com.example.demoPOEC.service.ClientDirectory;

@RestController
@RequestMapping("api")
public class ClientController {

	@Autowired
	private ClientDirectory clientDirectory;
//------------------------------------------------------------------------------------------

	@GetMapping("clients")
	public List<Client> getClient() {

		return clientDirectory.getClients();
	}
//------------------------------------------------------------------------------------------

	@GetMapping("client/{id}")
	public ResponseEntity<Client> getClient(@PathVariable("id") int id) {
		Optional<Client> optionalClient= clientDirectory.getClient(id);
		if (optionalClient.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(optionalClient.get());
		}
	}
//------------------------------------------------------------------------------------------

	@PostMapping("clients")
	public Client addClient(@RequestBody Client newClient) {
		clientDirectory.addClient(newClient);
		return newClient;
	}
//------------------------------------------------------------------------------------------

	@DeleteMapping("client/{id}")
	public void deleteClient(@PathVariable("id") int id) {
		clientDirectory.deleteClient(id);
	}
//------------------------------------------------------------------------------------------

	
	@PatchMapping("client/{id}")
	public void updateClient(@RequestBody Client client, @PathVariable("id") int id) {
		clientDirectory.updateClient(client, id);
	}

}