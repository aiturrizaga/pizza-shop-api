package pe.edu.vallegrande.ecommerce.model.mapper;

import org.mapstruct.*;
import pe.edu.vallegrande.ecommerce.model.dto.PersonDTO;
import pe.edu.vallegrande.ecommerce.model.dto.PersonResponseDTO;
import pe.edu.vallegrande.ecommerce.model.entity.Person;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PersonMapper {
    Person toEntity(PersonDTO personDto);

    PersonDTO toDto(Person person);

    PersonResponseDTO toResponse(Person person);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL)
    Person partialUpdate(PersonDTO personDTO, @MappingTarget Person person);
}