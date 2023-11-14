package pe.edu.vallegrande.ecommerce.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.vallegrande.ecommerce.exception.NotFoundException;
import pe.edu.vallegrande.ecommerce.model.dto.ProductDTO;
import pe.edu.vallegrande.ecommerce.model.entity.Product;
import pe.edu.vallegrande.ecommerce.model.mapper.ProductMapper;
import pe.edu.vallegrande.ecommerce.repository.ProductRepository;
import pe.edu.vallegrande.ecommerce.service.ProductService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductMapper productMapper;
    private final ProductRepository productRepository;

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public Product create(ProductDTO dto) {
        return productRepository.save(productMapper.toEntity(dto));
    }

    @Override
    public Product update(Long id, ProductDTO dto) {
        return productRepository.findById(id)
                .map(product -> productRepository.save(productMapper.partialUpdate(dto, product)))
                .orElseThrow(() -> new NotFoundException("Product not found"));
    }

    @Override
    public void disableById(Long id) {
        productRepository.disableById(id);
    }

    @Override
    public List<Product> searchByName(String name) {
        return productRepository.searchByName(name);
    }
}
