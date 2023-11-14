package pe.edu.vallegrande.ecommerce.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import pe.edu.vallegrande.ecommerce.model.dto.ProductDTO;
import pe.edu.vallegrande.ecommerce.model.entity.Product;
import pe.edu.vallegrande.ecommerce.service.ProductService;

import java.net.URI;
import java.util.Optional;

@RestController
@Tag(name = "Product")
@RequiredArgsConstructor
@RequestMapping("/v1/products")
public class ProductController {

    private final ProductService productService;

    @Operation(summary = "Get product by id")
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Product>> getProduct(@PathVariable Long id) {
        return ResponseEntity.ok(productService.findById(id));
    }

    @Operation(summary = "Create new product")
    @PostMapping
    public ResponseEntity<Product> saveProduct(@RequestBody ProductDTO product) {
        Product response = productService.create(product);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(response.getId())
                .toUri();
        return ResponseEntity.created(location).body(response);
    }

    @Operation(summary = "Update product by id")
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateCategory(@PathVariable Long id, @RequestBody ProductDTO product) {
        return ResponseEntity.ok(productService.update(id, product));
    }

    @Operation(summary = "Disable product by id")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> disableCategory(@PathVariable Long id) {
        productService.disableById(id);
        return ResponseEntity.noContent().build();
    }
}
