package com.restSpring.msscbrewery.web.services;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.restSpring.msscbrewery.web.model.BeerDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BeerServiceImpl implements BeerService {

	@Override
	public BeerDto getBeerById(UUID beerId) {
		// TODO Auto-generated method stub
		return BeerDto.builder().id(beerId)
				.beerName("Galaxy Cat")
				.beerStyle("Pale Ale")
				.build();
	}

	@Override
	public BeerDto saveNewBeer(BeerDto beerDto) {
		beerDto.setId(UUID.randomUUID());
		return beerDto;
	}

	@Override
	public void updateBeer(UUID id,BeerDto beerDto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteBeer(UUID beerId) {
		// TODO Auto-generated method stub
		log.debug("Deleting a beer...!");
	}
	
}
