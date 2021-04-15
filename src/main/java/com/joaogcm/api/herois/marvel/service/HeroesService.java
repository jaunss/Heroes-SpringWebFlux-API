package com.joaogcm.api.herois.marvel.service;

import org.springframework.stereotype.Service;

import com.joaogcm.api.herois.marvel.document.Heroes;
import com.joaogcm.api.herois.marvel.repository.HeroesRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class HeroesService {

	private HeroesRepository heroesRepository;

	public HeroesService(HeroesRepository heroesRepository) {
		this.heroesRepository = heroesRepository;
	}

	public Flux<Heroes> findAll() {
		return Flux.fromIterable(this.heroesRepository.findAll());
	}

	public Mono<Heroes> findById(String id) {
		return Mono.justOrEmpty(this.heroesRepository.findById(id));
	}

	public Mono<Heroes> insert(Heroes heroes) {
		return Mono.justOrEmpty(this.heroesRepository.save(heroes));
	}

	public Mono<Boolean> deleteById(String id) {
		heroesRepository.deleteById(id);
		return Mono.just(true);
	}
}