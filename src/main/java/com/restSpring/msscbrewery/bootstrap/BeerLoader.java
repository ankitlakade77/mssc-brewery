package com.restSpring.msscbrewery.bootstrap;

import java.math.BigDecimal;

import org.springframework.boot.CommandLineRunner;

import com.restSpring.msscbrewery.domain.Beer;
import com.restSpring.msscbrewery.repositories.BeerRepository;

public class BeerLoader implements CommandLineRunner{
	
	private final BeerRepository beerRepository;
	
	public static final String BEER_1_UPC="33370100000231";
	public static final String BEER_2_UPC="33170200000245";

	public BeerLoader(BeerRepository beerRepository) {
		super();
		this.beerRepository = beerRepository;
	}
	
	@Override
	public void run(String... args) throws Exception {
		
	}
	
	private void loadBeer() {
		if(beerRepository.count() == 0) {
			beerRepository.save(Beer.builder()
					.beerName("Mango Bobs")
					.beerStyle("IPA")
					.quantityToBrew(200)
					.minOnHand(12)
					.upc(BEER_1_UPC)
					.price(new BigDecimal("12.95"))
					.build());
			
			beerRepository.save(Beer.builder()
					.beerName("Galaxy Cat")
					.beerStyle("PALE_ALE")
					.quantityToBrew(300)
					.minOnHand(35)
					.upc(BEER_2_UPC)
					.price(new BigDecimal("11.95"))
					.build());
		}
	}

}
