package com.restSpring.msscbrewery.repositories;

import java.util.UUID;
import org.springframework.data.repository.PagingAndSortingRepository;
import com.restSpring.msscbrewery.domain.Beer;


public interface BeerRepository extends PagingAndSortingRepository<Beer, UUID>{

}
