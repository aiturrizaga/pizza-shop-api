package pe.edu.vallegrande.ecommerce.model.mapper;

import org.mapstruct.*;
import pe.edu.vallegrande.ecommerce.model.dto.OrderDTO;
import pe.edu.vallegrande.ecommerce.model.entity.Order;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface OrderMapper {
    @Mapping(source = "userId", target = "person.id")
    Order toEntity(OrderDTO orderDTO);

    @Mapping(source = "person.id", target = "userId")
    OrderDTO toDto(Order order);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(source = "userId", target = "person.id")
    Order partialUpdate(OrderDTO orderDTO, @MappingTarget Order order);
}