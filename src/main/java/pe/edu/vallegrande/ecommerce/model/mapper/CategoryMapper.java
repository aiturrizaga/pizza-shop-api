package pe.edu.vallegrande.ecommerce.model.mapper;

import org.mapstruct.*;
import org.springframework.data.domain.Page;
import pe.edu.vallegrande.ecommerce.model.dto.CategoryDTO;
import pe.edu.vallegrande.ecommerce.model.dto.PageableDTO;
import pe.edu.vallegrande.ecommerce.model.entity.Category;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CategoryMapper {
    Category toEntity(CategoryDTO categoryDTO);

    CategoryDTO toDto(Category category);

    PageableDTO<Category> toPage(Page<Category> categories);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL)
    Category partialUpdate(CategoryDTO categoryDTO, @MappingTarget Category category);
}