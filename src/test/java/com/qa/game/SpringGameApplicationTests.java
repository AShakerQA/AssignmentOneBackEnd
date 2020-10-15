package com.qa.game;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.qa.game.persistence.domain.Game;

import nl.jqno.equalsverifier.EqualsVerifier;

@SpringBootTest
class SpringGameApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void giveCoverage() {
		EqualsVerifier.forClass(Game.class).usingGetClass().verify();
	}
}
