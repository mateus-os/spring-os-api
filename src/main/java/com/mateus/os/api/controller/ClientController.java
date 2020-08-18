package com.mateus.os.api.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mateus.os.domain.model.Client;

@RestController
public class ClientController {

	@GetMapping("/clients")
	public List<Client> list() {
		var client1 = new Client();
		client1.setId(1L);
		client1.setName("John Cena");
		client1.setPhone("34 565454-5555");
		client1.setEmail("john@gmail.com");

		var client2 = new Client();
		client2.setId(2L);
		client2.setName("Mary");
		client2.setPhone("11 999454-5555");
		client2.setEmail("mary@gmail.com");

		return Arrays.asList(client1, client2);
	}
}