package com.example.demo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.example.demo.domain.BikeDto;
import com.example.demo.entities.Bike;

@Mapper
public interface BikeMapper {

	BikeMapper INSTANCE = Mappers.getMapper(BikeMapper.class);

	BikeDto toDto(Bike entity);
	Bike toEntity(BikeDto dto);
}
