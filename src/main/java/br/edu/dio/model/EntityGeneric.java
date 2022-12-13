package br.edu.dio.model;

import java.time.LocalDate;

import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class EntityGeneric extends Entity {

	private LocalDate dateRegistration;
	private Boolean active;

	public LocalDate getDateRegistration() {
		return dateRegistration;
	}

	public void setDateRegistration(LocalDate dateRegistration) {
		this.dateRegistration = dateRegistration;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

}
