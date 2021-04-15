package com.joaogcm.api.herois.marvel.repository;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.joaogcm.api.herois.marvel.document.Heroes;

@EnableScan
@Repository
public interface HeroesRepository extends CrudRepository<Heroes, String> {

}