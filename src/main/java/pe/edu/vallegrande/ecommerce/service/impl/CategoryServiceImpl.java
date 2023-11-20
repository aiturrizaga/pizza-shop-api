package pe.edu.vallegrande.ecommerce.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.vallegrande.ecommerce.exception.NotFoundException;
import pe.edu.vallegrande.ecommerce.model.dto.CategoryDTO;
import pe.edu.vallegrande.ecommerce.model.dto.PageableDTO;
import pe.edu.vallegrande.ecommerce.model.entity.Category;
import pe.edu.vallegrande.ecommerce.model.mapper.CategoryMapper;
import pe.edu.vallegrande.ecommerce.repository.CategoryRepository;
import pe.edu.vallegrande.ecommerce.service.CategoryService;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryMapper categoryMapper;
    private final CategoryRepository categoryRepository;

    @Override
    public Optional<Category> findById(Long id) {
        return categoryRepository.findById(id);
    }

    @Override
    public PageableDTO<Category> findAll(Pageable pageable) {
        return categoryMapper.toPage(categoryRepository.findAllByActive(true, pageable));
    }

    @Override
    public Category create(CategoryDTO dto) {
        return categoryRepository.save(categoryMapper.toEntity(dto));
    }

    @Override
    public Category update(Long id, CategoryDTO dto) {
        return categoryRepository.findById(id)
                .map(category -> categoryRepository.save(categoryMapper.partialUpdate(dto, category)))
                .orElseThrow(() -> new NotFoundException("Category not found"));
    }

    @Transactional
    @Override
    public void disableById(Long id) {
        categoryRepository.disableById(id);
    }
}
