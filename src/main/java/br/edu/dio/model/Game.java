package br.edu.dio.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Game extends EntityGeneric {

	private String name;

	@Column(length = 500)
	private String description;
	private String cover;
	private long votes;

}
