package pe.edu.vallegrande.ecommerce.service;

import org.springframework.data.domain.Pageable;
import pe.edu.vallegrande.ecommerce.model.dto.PageableDTO;
import pe.edu.vallegrande.ecommerce.model.dto.ProductDTO;
import pe.edu.vallegrande.ecommerce.model.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    Optional<Product> findById(Long id);

    PageableDTO<Product> findAll(Pageable pageable);

    Product create(ProductDTO dto);

    Product update(Long id, ProductDTO dto);

    void disableById(Long id);

    List<Product> searchByName(String name);
}
