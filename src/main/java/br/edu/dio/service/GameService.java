package br.edu.dio.service;

import br.edu.dio.model.Game;

public interface GameService extends CrudService<Game>{

	public Game update(Long id, Game game);
	public void vote(Long id);

}
