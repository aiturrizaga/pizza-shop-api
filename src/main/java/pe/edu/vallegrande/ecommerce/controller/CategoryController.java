package pe.edu.vallegrande.ecommerce.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import pe.edu.vallegrande.ecommerce.model.dto.CategoryDTO;
import pe.edu.vallegrande.ecommerce.model.dto.PageableDTO;
import pe.edu.vallegrande.ecommerce.model.entity.Category;
import pe.edu.vallegrande.ecommerce.service.CategoryService;

import java.net.URI;
import java.util.Optional;

@RestController
@Tag(name = "Category")
@RequiredArgsConstructor
@RequestMapping("/v1/categories")
public class CategoryController {

    private final CategoryService categoryService;

    @Operation(summary = "Get all categories")
    @GetMapping
    public ResponseEntity<PageableDTO<Category>> getCategory(Pageable pageable) {
        return ResponseEntity.ok(categoryService.findAll(pageable));
    }

    @Operation(summary = "Get category by id")
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Category>> getCategory(@PathVariable Long id) {
        return ResponseEntity.ok(categoryService.findById(id));
    }

    @Operation(summary = "Create new category")
    @PostMapping
    public ResponseEntity<Category> saveCategory(@RequestBody CategoryDTO category) {
        Category response = categoryService.create(category);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(response.getId())
                .toUri();
        return ResponseEntity.created(location).body(response);
    }

    @Operation(summary = "Update category by id")
    @PutMapping("/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable Long id, @RequestBody CategoryDTO category) {
        return ResponseEntity.ok(categoryService.update(id, category));
    }

    @Operation(summary = "Disable category by id")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> disableCategory(@PathVariable Long id) {
        categoryService.disableById(id);
        return ResponseEntity.noContent().build();
    }
}
