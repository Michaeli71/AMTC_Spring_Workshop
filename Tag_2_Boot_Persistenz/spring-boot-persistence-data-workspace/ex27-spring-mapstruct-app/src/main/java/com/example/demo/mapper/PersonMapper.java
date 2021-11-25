package com.example.demo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.example.demo.domain.PersonDto;
import com.example.demo.domain.PersonNameDTO;
import com.example.demo.entities.Person;

@Mapper
public interface PersonMapper {
	@Mappings({ @Mapping(target = "personId", source = "entity.id"),
			@Mapping(target = "fullName", source = "entity.name") })
	PersonNameDTO toNameDto(Person entity);
	
	PersonDto toDto(Person entity);
	
	Person toEntity(PersonDto dto);
}