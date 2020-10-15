package com.qa.game.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.game.persistence.domain.Game;
import com.qa.game.persistence.domain.GameRepo;

@Service
public class GameService {

	@Autowired
	private GameRepo repo;

	public GameService(GameRepo repo) {
		super();
		this.repo = repo;
	}

	public Game createGame(Game game) {
		return this.repo.save(game);
	}

	public List<Game> getGame() {
		return this.repo.findAll();
	}

	public Game updateGame(Game game, Long id) {
		Game oldGame = this.repo.findById(id).get();

		oldGame.setName(game.getName());
		oldGame.setGenre(game.getGenre());
		oldGame.setPrice(game.getPrice());

		return this.repo.save(oldGame);
	}

	public boolean deleteGame(long id) {
		this.repo.deleteById(id);
		// return true if it does not exist, delete was successful
		return !this.repo.existsById(id);
	}

}
