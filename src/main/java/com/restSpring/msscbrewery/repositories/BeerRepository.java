package com.restSpring.msscbrewery.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import com.restSpring.msscbrewery.domain.Beer;


public interface BeerRepository extends JpaRepository<Beer, UUID>{

	Page<Beer> findAllByBeerName(String beerName, Pageable pageable);

    Optional<Beer> findByUpc(String upc);
}
