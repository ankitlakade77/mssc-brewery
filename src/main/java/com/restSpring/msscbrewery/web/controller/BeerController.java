package com.restSpring.msscbrewery.web.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

@RestController
@RequestMapping("/api/v1/beer/")
public class BeerController {
	
	private final BeerService beerService;
	
	@Autowired
	public BeerController(BeerService beerService) {
		this.beerService = beerService;
	}


	@GetMapping("/{beerId}")
	public ResponseEntity<BeerDto> getBeer(@PathVariable UUID beerId){
		
		return new ResponseEntity<>(beerService.getBeerById(beerId), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity saveNewBeer(@RequestBody BeerDto beerDto){
		
		BeerDto savedBeerDto = beerService.saveNewBeer(beerDto);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Location", "/api/v1/beer/"+savedBeerDto.getId().toString());
		return new ResponseEntity(headers, HttpStatus.CREATED);
	}
	
	@PutMapping("/{beerId}")
	public ResponseEntity<BeerDto> handleUpdate(@PathVariable("beerId") UUID beerId, @RequestBody BeerDto beerDto ){
		
		beerService.updateBeer(beerId,beerDto);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping({"/beerId"})
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteBeer(@PathVariable("beerId") UUID beerId){
		beerService.deleteBeer(beerId);
	}
	
}
