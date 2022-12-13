package br.edu.dio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.dio.model.Game;
import br.edu.dio.service.GameService;

@RestController
@RequestMapping("/games")
public class GameController {

	@Autowired
	GameService gameService;

	@GetMapping
	public ResponseEntity<List<Game>> findAll() {
		List<Game> listGame = gameService.findAll();
		return ResponseEntity.ok(listGame);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Game> findById(@PathVariable Long id) {
		Game game = gameService.findById(id);
		return ResponseEntity.ok(game);
	}

	@PostMapping
	public ResponseEntity<Game> insert(@RequestBody Game game) {
		Game gameSave = gameService.insert(game);
		return ResponseEntity.status(HttpStatus.CREATED).body(gameSave);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Game> update(@RequestBody Game game, @PathVariable Long id) {
		Game gameUpdate = gameService.update(id, game);
		return ResponseEntity.ok(gameUpdate);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		gameService.delete(id);
		return ResponseEntity.noContent().build();
	}

	@PatchMapping("/{id}/vote")
	public ResponseEntity<Void> vote(@PathVariable Long id) {
		findById(id);
		gameService.vote(id);
		return ResponseEntity.ok().build();
	}
}
