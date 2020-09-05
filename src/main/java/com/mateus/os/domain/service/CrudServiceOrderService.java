package com.mateus.os.domain.service;

import java.time.OffsetDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mateus.os.domain.exception.BusinessException;
import com.mateus.os.domain.model.Client;
import com.mateus.os.domain.model.ServiceOrder;
import com.mateus.os.domain.model.StatusSO;
import com.mateus.os.domain.repository.ClientRepository;
import com.mateus.os.domain.repository.ServiceOrderRepository;

@Service
public class CrudServiceOrderService {

	@Autowired
	private ServiceOrderRepository soRepository;

	@Autowired
	private ClientRepository clientRepository;

	public ServiceOrder create(ServiceOrder so) {
		Client client = clientRepository.findById(so.getClient().getId())
				.orElseThrow(() -> new BusinessException("Client not found"));

		so.setClient(client);
		so.setStatus(StatusSO.OPEN);
		so.setOpenDate(OffsetDateTime.now());

		return soRepository.save(so);
	}
}
