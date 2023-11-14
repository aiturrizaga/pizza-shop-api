package pe.edu.vallegrande.ecommerce.service;

import pe.edu.vallegrande.ecommerce.model.dto.ProductDTO;
import pe.edu.vallegrande.ecommerce.model.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    Optional<Product> findById(Long id);

    Product create(ProductDTO dto);

    Product update(Long id, ProductDTO dto);

    void disableById(Long id);

    List<Product> searchByName(String name);
}
