package com.mateus.os.api.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mateus.os.domain.model.ServiceOrder;
import com.mateus.os.domain.repository.ServiceOrderRepository;
import com.mateus.os.domain.service.CrudServiceOrderService;

@RestController
@RequestMapping("/serviceorders")
public class ServiceOrderController {
	
	@Autowired
	private CrudServiceOrderService crudServiceOrder;
	
	@Autowired
	private ServiceOrderRepository soRepository;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ServiceOrder create(@Valid @RequestBody ServiceOrder so) {
		return crudServiceOrder.create(so);		
	}
	
	@GetMapping
	public List<ServiceOrder> list() {
		return soRepository.findAll();
	}
	
	@GetMapping("/{serviceOrderId}")
	public ResponseEntity<ServiceOrder> find(@PathVariable Long serviceOrderId) {
		Optional<ServiceOrder> serviceOrder = soRepository.findById(serviceOrderId);
		
		if (serviceOrder.isPresent()) {
			return ResponseEntity.ok(serviceOrder.get());
		}
		
		return ResponseEntity.notFound().build();
	}
}
