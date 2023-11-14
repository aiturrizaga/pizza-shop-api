package pe.edu.vallegrande.ecommerce.model.mapper;

import org.mapstruct.*;
import pe.edu.vallegrande.ecommerce.model.dto.PersonAddressDTO;
import pe.edu.vallegrande.ecommerce.model.entity.PersonAddress;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface PersonAddressMapper {
    PersonAddress toEntity(PersonAddressDTO personAddressDTO);

    PersonAddressDTO toDto(PersonAddress personAddress);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    PersonAddress partialUpdate(PersonAddressDTO personAddressDTO, @MappingTarget PersonAddress personAddress);
}