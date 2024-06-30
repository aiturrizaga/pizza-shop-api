package pe.edu.vallegrande.ecommerce.model.mapper;

import org.mapstruct.*;
import org.springframework.data.domain.Page;
import pe.edu.vallegrande.ecommerce.model.dto.PageableDTO;
import pe.edu.vallegrande.ecommerce.model.dto.PersonDTO;
import pe.edu.vallegrande.ecommerce.model.dto.PersonResponseDTO;
import pe.edu.vallegrande.ecommerce.model.entity.Person;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PersonMapper {
    Person toEntity(PersonDTO personDto);

    PersonDTO toDto(Person person);

    PersonResponseDTO toResponse(Person person);

    PageableDTO<Person> toPage(Page<Person> persons);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL)
    Person partialUpdate(PersonDTO personDTO, @MappingTarget Person person);
}