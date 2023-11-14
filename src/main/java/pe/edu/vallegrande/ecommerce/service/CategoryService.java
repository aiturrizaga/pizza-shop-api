package pe.edu.vallegrande.ecommerce.service;

import pe.edu.vallegrande.ecommerce.model.dto.CategoryDTO;
import pe.edu.vallegrande.ecommerce.model.entity.Category;

import java.util.Optional;

public interface CategoryService {
    Optional<Category> findById(Long id);

    Category create(CategoryDTO dto);

    Category update(Long id, CategoryDTO dto);

    void disableById(Long id);
}
