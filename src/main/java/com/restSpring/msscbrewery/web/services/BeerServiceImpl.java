package com.restSpring.msscbrewery.web.services;

import java.util.UUID;
import org.springframework.stereotype.Service;

import com.restSpring.msscbrewery.domain.Beer;
import com.restSpring.msscbrewery.repositories.BeerRepository;
import com.restSpring.msscbrewery.web.controller.NotFoundException;
import com.restSpring.msscbrewery.web.mapper.BeerMapper;
import com.restSpring.msscbrewery.web.model.BeerDto;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@Service
public class BeerServiceImpl implements BeerService {

	private final BeerRepository beerRepository;
	private final BeerMapper beerMapper;
	
	@Override
	public BeerDto getBeerById(UUID beerId) {
		// TODO Auto-generated method stub
		return beerMapper.BeerToBeerDto(beerRepository.findById(beerId).orElseThrow(NotFoundException::new));
	}

	@Override
	public BeerDto saveNewBeer(BeerDto beerDto) {
		//Saving the Beer Object
		return beerMapper.BeerToBeerDto(beerRepository.save(beerMapper.BeerDtoToBeer(beerDto)));
	}

	@Override
	public BeerDto updateBeer(UUID id,BeerDto beerDto) {
		
		Beer beer = beerRepository.findById(id).orElseThrow(NotFoundException::new);
		
		beer.setBeerName(beerDto.getBeerName());
		beer.setBeerStyle(beerDto.getBeerStyle());
		beer.setPrice(beerDto.getPrice());
		beer.setUpc(beerDto.getUpc());
		
		return beerMapper.BeerToBeerDto(beerRepository.save(beer));
	}

	@Override
	public void deleteBeer(UUID beerId) {
		// TODO Auto-generated method stub
		log.debug("Deleting a beer...!");
	}
	
}
