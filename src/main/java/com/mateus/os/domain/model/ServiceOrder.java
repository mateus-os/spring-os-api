package com.mateus.os.domain.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.mateus.os.api.model.Comment;
import com.mateus.os.domain.exception.BusinessException;

@Entity
public class ServiceOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	private Client client;

	private String description;
	private BigDecimal price;

	@Enumerated(EnumType.STRING)
	private StatusSO status;

	private OffsetDateTime openDate;
	private OffsetDateTime closeDate;

	@OneToMany(mappedBy = "serviceOrder")
	private List<Comment> comments = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

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

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ServiceOrder other = (ServiceOrder) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	public boolean canBeClosed() {
		return StatusSO.OPEN.equals(getStatus());
	}
	
	public boolean cannotBeClosed() {
		return !StatusSO.OPEN.equals(getStatus());
	}

	public void finalizar() {
		if (cannotBeClosed()) {
			throw new BusinessException("Service Order cannot be finished");
		}

		setStatus(StatusSO.FINISHED);
		setCloseDate(OffsetDateTime.now());
	}
}