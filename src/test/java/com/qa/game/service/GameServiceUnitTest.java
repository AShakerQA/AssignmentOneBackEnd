package com.qa.game.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.qa.game.persistence.domain.Game;
import com.qa.game.persistence.domain.GameRepo;

@SpringBootTest
public class GameServiceUnitTest {

	@Autowired
	private GameService service;

	@MockBean // PROXY REPO
	private GameRepo repo;

	// behaviour driven development,
	// Given, When, Then
	@Test
	void testCreate() {
		// Given -passing into method
		long id = 1L;
		Game newGame = new Game("genshin", "rpg", 5);
		Game savedGame = new Game("genshin", "rpg", 5);
		savedGame.setId(id);
		// When
		// continue from video 33
		// skip save method and return savedGame instead
		Mockito.when(this.repo.save(newGame)).thenReturn(savedGame);
		// Then
		assertThat(this.service.createGame(newGame)).isEqualTo(savedGame);
	}

	@Test
	void testUpdate() {
		// Given
		Long id = 1L;
		// data that being passed in
		Game newGame = new Game("genshin", "rpg", 5);
		// found by findById
		Game oldGame = new Game("osrs", "mmorpg", 15);
		oldGame.setId(id);
		// saved to db and returned game after put method
		Game updatedGame = new Game("genshin", "rpg", 5);
		updatedGame.setId(id);
		// When
		Mockito.when(this.repo.findById(id)).thenReturn(Optional.of(oldGame));
		Mockito.when(this.repo.save(updatedGame)).thenReturn(updatedGame);
		// Then
		assertThat(this.service.updateGame(newGame, id)).isEqualTo(updatedGame);
	}

	@Test
	void testGet() {
		// Given
		Game game = new Game("genshin", "rpg", 5);
		game.setId(1L);
		List<Game> games = new ArrayList<>();
		games.add(game);
		// When
		Mockito.when(this.repo.findAll()).thenReturn(games);
		// Then
		assertThat(this.service.getGame()).isEqualTo(games);
		Mockito.verify(this.repo, Mockito.times(1)).findAll();
	}

	@Test
	void testDelete() {
		// Given
		Long id = 1L;
		boolean found = false;
		// When
		Mockito.when(this.repo.existsById(id)).thenReturn(found);
		// Then
		assertThat(this.service.deleteGame(id)).isEqualTo(!found);
		Mockito.verify(this.repo, Mockito.times(1)).existsById(id);
	}
}