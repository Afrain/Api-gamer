package br.edu.dio.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.dio.model.EntityGeneric;
import br.edu.dio.service.CrudService;
import br.edu.dio.service.exception.NoContentException;

public abstract class BaseCrudService<E extends EntityGeneric, T extends JpaRepository<E, Long>>
		implements CrudService<E> {

	protected T repository;

	public BaseCrudService(T repository) {
		this.repository = repository;
	}

	@Override
	public List<E> findAll() {
		return this.repository.findAll();
	}

	@Override
	public E findById(Long id) {
		return repository.findById(id).orElseThrow(() -> new NoContentException());
	}

	@Override
	public E insert(E entity) {
		entity.setId(null);
		entity.setActive(true);
		entity.setDateRegistration(LocalDate.now());
		return repository.save(entity);
	}

	@Override
	public E update(Long id, E entity) {
		E entityBD = findById(id);
		entity.setActive(entityBD.getActive());
		entity.setDateRegistration(entityBD.getDateRegistration());
		BeanUtils.copyProperties(entity, entityBD, "id");
		return repository.save(entityBD);
	}

	@Override
	public void delete(Long id) {
		E entity = findById(id);
		repository.delete(entity);
	}
}
