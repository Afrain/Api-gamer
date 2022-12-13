package br.edu.dio.service;

import java.util.List;

public interface CrudService<E> {
	
	List<E> findAll();
	
	E findById(Long id);
	
	E insert(E entity);
	
	E update(Long id, E entity);
	
	void delete(Long id);
	
}