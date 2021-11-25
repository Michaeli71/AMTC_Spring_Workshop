package com.example.demo.mapper;

import com.example.demo.domain.BikeDto;
import com.example.demo.entities.Bike;
import com.example.demo.entities.BikeType;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-11-25T09:15:27+0100",
    comments = "version: 1.4.2.Final, compiler: Eclipse JDT (IDE) 1.4.50.v20210914-1429_BETA_JAVA17, environment: Java 16.0.2 (Oracle Corporation)"
)
public class BikeMapperImpl implements BikeMapper {

    @Override
    public BikeDto toDto(Bike entity) {
        if ( entity == null ) {
            return null;
        }

        String brand = null;
        String type = null;

        brand = entity.getBrand();
        if ( entity.getType() != null ) {
            type = entity.getType().name();
        }

        BikeDto bikeDto = new BikeDto( brand, type );

        return bikeDto;
    }

    @Override
    public Bike toEntity(BikeDto dto) {
        if ( dto == null ) {
            return null;
        }

        String brand = null;
        BikeType type = null;

        brand = dto.getBrand();
        if ( dto.getType() != null ) {
            type = Enum.valueOf( BikeType.class, dto.getType() );
        }

        Bike bike = new Bike( brand, type );

        return bike;
    }
}
