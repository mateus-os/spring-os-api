package com.mateus.os.api.model;

import java.math.BigDecimal;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ServiceOrderInput {

	@NotBlank
	private String description;

	@NotNull
	private BigDecimal price;

	@Valid
	@NotNull
	private ClienteIdInput client;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public ClienteIdInput getClient() {
		return client;
	}

	public void setClient(ClienteIdInput cliente) {
		this.client = cliente;
	}
}
