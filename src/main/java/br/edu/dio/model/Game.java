package br.edu.dio.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Game extends EntityGeneric {

	private String name;

	@Column(length = 500)
	private String description;
	private String cover;
	private long votes;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCover() {
		return cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

	public long getVotes() {
		return votes;
	}

	public void setVotes(long votes) {
		this.votes = votes;
	}

}
