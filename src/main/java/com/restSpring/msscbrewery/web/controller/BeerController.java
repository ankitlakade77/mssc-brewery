package com.restSpring.msscbrewery.web.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.restSpring.msscbrewery.web.model.*;
import com.restSpring.msscbrewery.web.services.BeerService;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

// @RequiredArgsConstructor this can be used to create BeerController with BeerService as component.
@RestController
@RequestMapping("/api/v1/")
public class BeerController {
	
	private final BeerService beerService;
	
	@Autowired
	public BeerController(BeerService beerService) {
		this.beerService = beerService;
	}


	@GetMapping("beer/{beerId}")
	public ResponseEntity<BeerDto> getBeer(@PathVariable UUID beerId){
		
		return new ResponseEntity<>(beerService.getBeerById(beerId), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity saveNewBeer(@Validated @RequestBody BeerDto beerDto){
		
		BeerDto savedBeerDto = beerService.saveNewBeer(beerDto);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Location", "/api/v1/beer/"+savedBeerDto.getId().toString());
		return new ResponseEntity<>(headers, HttpStatus.CREATED);
	}
	
	@PutMapping("beer/{beerId}")
	public ResponseEntity<BeerDto> handleUpdate(@PathVariable("beerId") UUID beerId, @Validated @RequestBody BeerDto beerDto ){
		
		return new ResponseEntity<>(beerService.updateBeer(beerId,beerDto), HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping("beer/{beerId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteBeer(@PathVariable("beerId") UUID beerId){
		beerService.deleteBeer(beerId);
	}
	
	
	@GetMapping("beerUpc/{upc}")
	public ResponseEntity<BeerDto> getBeerByUpc(@PathVariable String upc){
		
		return new ResponseEntity<>(beerService.getBeerByUpc(upc), HttpStatus.OK);
	}
	
	
}
