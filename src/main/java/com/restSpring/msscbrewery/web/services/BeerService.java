package com.restSpring.msscbrewery.web.services;

import java.util.UUID;
import com.restSpring.msscbrewery.web.model.BeerDto;

public interface BeerService {
	
	BeerDto getBeerById(UUID beerId);
	BeerDto saveNewBeer(BeerDto beerDto);
	BeerDto updateBeer(UUID id,BeerDto beerDto);
	void deleteBeer(UUID beerId);
}
