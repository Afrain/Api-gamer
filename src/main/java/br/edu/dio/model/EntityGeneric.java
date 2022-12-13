package br.edu.dio.model;

import java.time.LocalDate;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public class EntityGeneric extends Entity {

	private LocalDate dateRegistration;
	private Boolean active;

}
