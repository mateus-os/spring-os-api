package com.mateus.os.api.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import com.mateus.os.domain.model.StatusSO;

public class ServiceOrderModel {

	private Long id;
	private ClientModel client;
	private String description;
	private BigDecimal price;
	private StatusSO status;
	private OffsetDateTime openDate;
	private OffsetDateTime closeDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public ClientModel getClient() {
		return client;
	}

	public void setClient(ClientModel client) {
		this.client = client;
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

	public StatusSO getStatus() {
		return status;
	}

	public void setStatus(StatusSO status) {
		this.status = status;
	}

	public OffsetDateTime getOpenDate() {
		return openDate;
	}

	public void setOpenDate(OffsetDateTime openDate) {
		this.openDate = openDate;
	}

	public OffsetDateTime getCloseDate() {
		return closeDate;
	}

	public void setCloseDate(OffsetDateTime closeDate) {
		this.closeDate = closeDate;
	}
}
