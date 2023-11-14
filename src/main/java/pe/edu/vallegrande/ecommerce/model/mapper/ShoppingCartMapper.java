package pe.edu.vallegrande.ecommerce.model.mapper;

import org.mapstruct.*;
import pe.edu.vallegrande.ecommerce.model.dto.ShopCartDTO;
import pe.edu.vallegrande.ecommerce.model.dto.ShoppingCartDTO;
import pe.edu.vallegrande.ecommerce.model.entity.ShoppingCart;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ShoppingCartMapper {
    @Mapping(source = "productId", target = "product.id")
    ShoppingCart toEntity(ShoppingCartDTO shoppingCartDTO);

    @Mapping(source = "product.id", target = "productId")
    ShoppingCartDTO toDto(ShoppingCart shoppingCart);

    @Mapping(target = "quantity", constant = "1")
    @Mapping(source = "productId", target = "product.id")
    ShoppingCart toEntity(ShopCartDTO shopCartDTO);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(source = "productId", target = "product.id")
    ShoppingCart partialUpdate(ShoppingCartDTO shoppingCartDTO, @MappingTarget ShoppingCart shoppingCart);
}