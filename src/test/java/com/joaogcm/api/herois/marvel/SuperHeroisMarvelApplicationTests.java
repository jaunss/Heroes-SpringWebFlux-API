package com.joaogcm.api.herois.marvel;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

import static com.joaogcm.api.herois.marvel.constants.HeroesConstant.HEROES_ENDPOINT_LOCAL;
import com.joaogcm.api.herois.marvel.repository.HeroesRepository;

@SpringBootTest
class SuperHeroisMarvelApplicationTests {

	@Autowired
	private WebTestClient webTestClient;

	@Autowired
	private HeroesRepository heroesRepository;

	@Test
	void contextLoads() {

	}

	@Test
	public void heroesFindById() {
		webTestClient.get().uri(HEROES_ENDPOINT_LOCAL.concat("/{id}"), "10").exchange().expectStatus().isOk()
				.expectBody();
	}

	@Test
	public void heroesNotFound() {
		webTestClient.get().uri(HEROES_ENDPOINT_LOCAL.concat("/{id}"), "10").exchange().expectStatus().isNotFound();
	}

	@Test
	public void heroesDelete() {
		webTestClient.delete().uri(HEROES_ENDPOINT_LOCAL.concat("/{id}"), "1").accept(MediaType.APPLICATION_JSON)
				.exchange().expectStatus().isNotFound().expectBody(Void.class);
	}
}