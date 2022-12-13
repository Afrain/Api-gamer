package br.edu.dio.service.impl;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.dio.model.Game;
import br.edu.dio.repository.GameRepository;
import br.edu.dio.service.GameService;

@Service
public class GameServiceImpl extends BaseCrudService<Game, GameRepository> implements GameService {

	@Autowired
	public GameServiceImpl(GameRepository gameRepository) {
		super(gameRepository);
	}
	
	@Override
	public void vote(Long id) {
		Game game = super.findById(id);
		game.setVotes(game.getVotes() + 1);
		super.update(id, game);
	}

	@Override
	public Game update(Long id, Game game) {
		Optional<Game> gameBD = super.repository.findById(id);
		game.setActive(gameBD.get().getActive());
		game.setDateRegistration(gameBD.get().getDateRegistration());
		game.setVotes(gameBD.get().getVotes());
		BeanUtils.copyProperties(game, gameBD, "id");
		return super.repository.save(gameBD.get());
	}

}
