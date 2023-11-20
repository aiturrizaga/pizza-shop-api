package pe.edu.vallegrande.ecommerce.model.mapper;

import org.mapstruct.*;
import org.springframework.data.domain.Page;
import pe.edu.vallegrande.ecommerce.model.dto.PageableDTO;
import pe.edu.vallegrande.ecommerce.model.dto.ProductDTO;
import pe.edu.vallegrande.ecommerce.model.entity.Product;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProductMapper {
    @Mapping(source = "categoryId", target = "category.id")
    Product toEntity(ProductDTO productDTO);

    @Mapping(source = "category.id", target = "categoryId")
    ProductDTO toDto(Product product);

    PageableDTO<Product> toPage(Page<Product> products);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL)
    @Mapping(source = "categoryId", target = "category.id")
    Product partialUpdate(ProductDTO productDTO, @MappingTarget Product product);
}