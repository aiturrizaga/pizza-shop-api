package pe.edu.vallegrande.ecommerce.model.mapper;

import org.mapstruct.*;
import pe.edu.vallegrande.ecommerce.model.dto.CategoryDTO;
import pe.edu.vallegrande.ecommerce.model.entity.Category;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CategoryMapper {
    Category toEntity(CategoryDTO categoryDTO);

    CategoryDTO toDto(Category category);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL)
    Category partialUpdate(CategoryDTO categoryDTO, @MappingTarget Category category);
}