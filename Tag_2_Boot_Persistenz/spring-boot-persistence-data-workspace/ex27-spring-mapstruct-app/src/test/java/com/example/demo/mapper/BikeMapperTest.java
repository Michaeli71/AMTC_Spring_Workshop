package com.example.demo.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import com.example.demo.domain.BikeDto;
import com.example.demo.entities.Bike;
import com.example.demo.entities.BikeType;

public class BikeMapperTest {

	@Test
	public void shouldMapBikeToDto() {
		// given
		Bike cityRacer = new Bike("CANNONDALE", BikeType.CITYRACER);

		// when
		BikeDto bikeDto = BikeMapper.INSTANCE.toDto(cityRacer);

		// then
		assertNotNull(bikeDto);
		assertEquals("CANNONDALE", bikeDto.getBrand());
		assertEquals("CITYRACER", bikeDto.getType());
	}
	
	@Test
	public void shouldMapDtoToBike() {
		// given
		BikeDto racingDto = new BikeDto("CANNONDALE", "RACING");

		// when
		Bike bike = BikeMapper.INSTANCE.toEntity(racingDto);

		// then
		assertNotNull(bike);
		assertEquals("CANNONDALE", bike.getBrand());
		assertEquals(BikeType.RACING, bike.getType());
	}
}
