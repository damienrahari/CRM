package com.example.demoPOEC.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demoPOEC.dao.ClientRepository;
import com.example.demoPOEC.model.Client;



@Service
public class ClientDirectory {
	
	@Autowired
	private ClientRepository clientRepository;
	public void addClient(Client newClient) {
		clientRepository.save(newClient);
	}

	public List<Client> getClients() {
		return clientRepository.findAll();
	}


	
	public Optional<Client> getClient(Integer id) {
				return clientRepository.findById(id);
			
	}


	public void deleteClient(Integer id) {
		clientRepository.deleteById(id);
	}

		public void updateClient(Client clientToUpdate, Integer id) {
			clientRepository.save(clientToUpdate);
		}

}
