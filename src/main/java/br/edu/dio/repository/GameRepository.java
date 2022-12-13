package br.edu.dio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.dio.model.Game;

@Repository
public interface GameRepository extends JpaRepository<Game, Long>{

}
