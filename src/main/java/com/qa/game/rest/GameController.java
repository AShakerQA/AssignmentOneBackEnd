package com.qa.game.rest;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.game.persistence.domain.Game;
import com.qa.game.service.GameService;

@RestController
@CrossOrigin // Prevent CORS errors in front end
public class GameController {

	private GameService service;

	public GameController(GameService service) {
		super();
		this.service = service;
	}

	@PostMapping("/createGame")
	public ResponseEntity<Game> createGame(@RequestBody Game game) {
		System.out.println(game);
		return new ResponseEntity<Game>(this.service.createGame(game), HttpStatus.CREATED);
	}

	@GetMapping("/getGame")
	public ResponseEntity<List<Game>> getGame() {
		return ResponseEntity.ok(this.service.getGame());
	}

	@PutMapping("/updateGame")
	public ResponseEntity<Game> updateGame(@RequestBody Game game, @PathParam("id") long id) {
		return new ResponseEntity<Game>(this.service.updateGame(game, id), HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/remove/{id}")
	public ResponseEntity<Object> deleteGame(@PathVariable long id) {
		if (this.service.deleteGame(id)) {
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
