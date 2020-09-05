package com.mateus.os.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mateus.os.domain.exception.BusinessException;
import com.mateus.os.domain.model.Client;
import com.mateus.os.domain.repository.ClientRepository;

@Service
public class CrudClientService {

	@Autowired
	private ClientRepository clientRepository;

	public Client save(Client client) {
		Client clientExistent = clientRepository.findByEmail(client.getEmail());

		if (clientExistent != null && !clientExistent.equals(client)) {
			throw new BusinessException("That e-mail is taken, try another");
		}

		return clientRepository.save(client);
	}

	public void delete(Long clientId) {
		clientRepository.deleteById(clientId);
	}
}
