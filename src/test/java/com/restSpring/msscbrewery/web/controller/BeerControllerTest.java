package com.restSpring.msscbrewery.web.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.math.BigDecimal;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.restSpring.msscbrewery.web.model.BeerDto;
import com.restSpring.msscbrewery.web.services.BeerService;

@WebMvcTest(BeerController.class)
class BeerControllerTest {

	@MockBean
	BeerService beerService;

	@Autowired
	MockMvc mockMvc;

	@Autowired
	ObjectMapper objectMapper;
	
	BeerDto validBeer;

	public static final String BEER_1_UPC="33370100000231";
	public static final String BEER_2_UPC="33170200000245";
	
	@BeforeEach
	void setUp() throws Exception {
		validBeer = BeerDto.builder().id(UUID.randomUUID())
                .beerName("Beer1")
                .beerStyle("PALE_ALE")
                .price(BigDecimal.valueOf(1.12))
                .upc(BEER_1_UPC)
                .build();
	}

	@Test
	public void getBeer() throws Exception {
		given(beerService.getBeerById(any(UUID.class))).willReturn(validBeer);

		mockMvc.perform(get("/api/v1/beer/" + UUID.randomUUID().toString()).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.id", is(validBeer.getId().toString())))
				.andExpect(jsonPath("$.beerName", is("Beer1")));
	}

	@Test
	public void saveNewBeer() throws Exception {
		// given
		BeerDto beerDto = validBeer;
		beerDto.setId(null);
		BeerDto savedDto = BeerDto.builder().id(UUID.randomUUID()).beerName("New Beer").build();
		String beerDtoJson = objectMapper.writeValueAsString(beerDto);

		given(beerService.saveNewBeer(any())).willReturn(savedDto);

		mockMvc.perform(post("/api/v1/beer/").contentType(MediaType.APPLICATION_JSON).content(beerDtoJson))
				.andExpect(status().isCreated());

	}

	@Test
	public void updateBeerById() throws Exception {
		// given
		validBeer.setId(null);
		BeerDto beerDto = validBeer;
		String beerDtoJson = objectMapper.writeValueAsString(beerDto);

		// when
		mockMvc.perform(
				put("/api/v1/beer/" + UUID.randomUUID().toString()).contentType(MediaType.APPLICATION_JSON).content(beerDtoJson))
				.andExpect(status().isNoContent());

		then(beerService).should().updateBeer(any(), any());

	}

}
