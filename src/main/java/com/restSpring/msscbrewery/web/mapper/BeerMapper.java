package com.restSpring.msscbrewery.web.mapper;

import org.mapstruct.Mapper;

import com.restSpring.msscbrewery.domain.Beer;
import com.restSpring.msscbrewery.web.model.BeerDto;

@Mapper(uses = {DateMapper.class})
public interface BeerMapper {
	
	BeerDto BeerToBeerDto(Beer beer);
	Beer BeerDtoToBeer(BeerDto dto);
}
