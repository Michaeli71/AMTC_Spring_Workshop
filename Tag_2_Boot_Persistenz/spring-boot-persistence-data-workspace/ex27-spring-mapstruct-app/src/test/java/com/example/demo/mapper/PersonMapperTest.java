package com.example.demo.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import com.example.demo.domain.PersonDto;
import com.example.demo.domain.PersonNameDTO;
import com.example.demo.entities.Person;


public class PersonMapperTest {
	
	private PersonMapper mapper = Mappers.getMapper(PersonMapper.class);

	@Test
	public void mapToEntity() {
	    PersonDto personDto = new PersonDto();
	    personDto.setId(4711);
	    personDto.setName("Michael Inden");
	    personDto.setBirthday(LocalDate.of(1971, 2, 7));
	
	    Person person = mapper.toEntity(personDto);
	
	    assertEquals(personDto.getId(), person.getId());
	    assertEquals(personDto.getName(), person.getName());
	    assertEquals(personDto.getName(), person.getName());
	}
	
	@Test
	public void mapToDto() {
		Person person = new Person();
	    person.setId(4711);
	    person.setName("Michael Inden");
	    person.setBirthday(LocalDate.of(1971, 2, 7));
	
	    PersonDto personDto = mapper.toDto(person);
	
	    assertEquals(person.getId(), personDto.getId());
	    assertEquals(person.getName(), personDto.getName());
	    assertEquals(person.getName(), personDto.getName());
	}
	
	
	@Test
	public void mapToNameDto() {
		Person person = new Person();
	    person.setId(4711);
	    person.setName("Michael Inden");
	
	    PersonNameDTO nameDto = mapper.toNameDto(person);
	
	    assertEquals(person.getId(), nameDto.getPersonId());
	    assertEquals(person.getName(), nameDto.getFullName());
	}
}

