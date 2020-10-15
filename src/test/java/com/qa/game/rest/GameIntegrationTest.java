package com.qa.game.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.game.persistence.domain.Game;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Sql(scripts = { "classpath:Game-schema.sql",
		"classpath:Game-data.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
public class GameIntegrationTest {

	@Autowired
	private MockMvc mockMVC;

	@Autowired
	private ObjectMapper mapper;

	@Test
	void testCreate() throws Exception {
		// newGame to test
		Game newGame = new Game("genshin", "rpg", 5);
		// convert to JSON string
		String requestBody = this.mapper.writeValueAsString(newGame);
		// request = post method, JSON content type + content
		RequestBuilder request = post("/createGame").contentType(MediaType.APPLICATION_JSON).content(requestBody);

		ResultMatcher checkStatus = status().isCreated();
		// compare to original
		Game saveGame = new Game("genshin", "rpg", 5);
		saveGame.setId(2L);// 1L inserted by SQL file
		// convert to JSON string to compare with requestBody
		String resultBody = this.mapper.writeValueAsString(saveGame);

		ResultMatcher checkBody = content().json(resultBody);

		this.mockMVC.perform(request).andExpect(checkStatus).andExpect(checkBody);
		// new code added
		MvcResult result = this.mockMVC.perform(request).andExpect(checkStatus).andReturn();
		String reqBody = result.getResponse().getContentAsString();
		Game gameResult = this.mapper.readValue(reqBody, Game.class);
	}

	@Test
	void testUpdate() throws Exception {
		Game newGame = new Game("genshin", "rpg", 5);
		String requestBody = this.mapper.writeValueAsString(newGame);
		RequestBuilder request = put("/updateGame?id=1").contentType(MediaType.APPLICATION_JSON).content(requestBody);

		ResultMatcher checkStatus = status().isAccepted();
		Game savedGame = new Game("genshin", "rpg", 5);
		savedGame.setId(1L);

		String resultBody = this.mapper.writeValueAsString(savedGame);
		ResultMatcher checkBody = content().json(resultBody);

		this.mockMVC.perform(request).andExpect(checkStatus).andExpect(checkBody);
	}

	@Test
	void testDelete() throws Exception {
		RequestBuilder request = delete("/remove/1");
		ResultMatcher checkStatus = status().is(200);
		this.mockMVC.perform(request).andExpect(checkStatus);
	}

	@Test
	void testRead() throws Exception {
		Game game = new Game("genshin", "rpg", 5);
		game.setId(1L);
		List<Game> games = new ArrayList<>();
		games.add(game);
		String responseBody = this.mapper.writeValueAsString(games);

		this.mockMVC.perform(get("/getGame")).andExpect(status().isOk()).andExpect(content().json(responseBody));
	}

}