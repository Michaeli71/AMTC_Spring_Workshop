package com.example.demo.mapper;

import com.example.demo.domain.PersonDto;
import com.example.demo.domain.PersonNameDTO;
import com.example.demo.entities.Gender;
import com.example.demo.entities.Person;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-11-25T09:15:27+0100",
    comments = "version: 1.4.2.Final, compiler: Eclipse JDT (IDE) 1.4.50.v20210914-1429_BETA_JAVA17, environment: Java 16.0.2 (Oracle Corporation)"
)
public class PersonMapperImpl implements PersonMapper {

    @Override
    public PersonNameDTO toNameDto(Person entity) {
        if ( entity == null ) {
            return null;
        }

        PersonNameDTO personNameDTO = new PersonNameDTO();

        personNameDTO.setPersonId( entity.getId() );
        personNameDTO.setFullName( entity.getName() );

        return personNameDTO;
    }

    @Override
    public PersonDto toDto(Person entity) {
        if ( entity == null ) {
            return null;
        }

        PersonDto personDto = new PersonDto();

        personDto.setId( entity.getId() );
        personDto.setName( entity.getName() );
        personDto.setBirthday( entity.getBirthday() );
        if ( entity.getGender() != null ) {
            personDto.setGender( entity.getGender().name() );
        }

        return personDto;
    }

    @Override
    public Person toEntity(PersonDto dto) {
        if ( dto == null ) {
            return null;
        }

        Person person = new Person();

        person.setId( dto.getId() );
        person.setName( dto.getName() );
        person.setBirthday( dto.getBirthday() );
        if ( dto.getGender() != null ) {
            person.setGender( Enum.valueOf( Gender.class, dto.getGender() ) );
        }

        return person;
    }
}
