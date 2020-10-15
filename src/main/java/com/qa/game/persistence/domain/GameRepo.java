package com.qa.game.persistence.domain;

import org.springframework.data.jpa.repository.JpaRepository;

//JPA is the java persistence API

public interface GameRepo extends JpaRepository<Game, Long> {

}
