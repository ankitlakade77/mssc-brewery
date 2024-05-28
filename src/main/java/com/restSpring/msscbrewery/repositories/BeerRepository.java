package com.restSpring.msscbrewery.repositories;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import com.restSpring.msscbrewery.domain.Beer;


public interface BeerRepository extends JpaRepository<Beer, UUID>{

}
