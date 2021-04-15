package com.joaogcm.api.herois.marvel.controller;

import static com.joaogcm.api.herois.marvel.constants.HeroesConstant.HEROES_ENDPOINT_LOCAL;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.joaogcm.api.herois.marvel.document.Heroes;
import com.joaogcm.api.herois.marvel.repository.HeroesRepository;
import com.joaogcm.api.herois.marvel.service.HeroesService;
import static com.joaogcm.api.herois.marvel.constants.HeroesConstant.HEROES_ENDPOINT_LOCAL;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@Slf4j
public class HeroesController {

	HeroesService heroesService;
	HeroesRepository heroesRepository;

	private static final Logger logger = LoggerFactory.getLogger(HeroesController.class);

	public HeroesController(HeroesService heroesService, HeroesRepository heroesRepository) {
		this.heroesService = heroesService;
		this.heroesRepository = heroesRepository;
	}

	@GetMapping(HEROES_ENDPOINT_LOCAL)
	public Flux<Heroes> getAllItems() {
		logger.info("requesting the list off all heroes");
		return heroesService.findAll();
	}

	@GetMapping(HEROES_ENDPOINT_LOCAL + "/id")
	public Mono<ResponseEntity<Heroes>> findById(@PathVariable String id) {
		logger.info("requesting the hero with id {}", id);
		return heroesService.findById(id).map((item) -> new ResponseEntity<>(item, HttpStatus.OK))
				.defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@PostMapping(HEROES_ENDPOINT_LOCAL)
	@ResponseStatus(code = HttpStatus.CREATED)
	public Mono<Heroes> insert(@RequestBody Heroes heroes) {
		logger.info("a new hero was created");
		return heroesService.insert(heroes);
	}

	@DeleteMapping(HEROES_ENDPOINT_LOCAL + "/id")
	@ResponseStatus(code = HttpStatus.CONTINUE)
	public Mono<HttpStatus> deleteById(@PathVariable String id) {
		heroesService.deleteById(id);
		logger.info("deleting a hero with id {}", id);
		return Mono.just(HttpStatus.CONTINUE);
	}

}