package pe.edu.vallegrande.ecommerce.service;

import pe.edu.vallegrande.ecommerce.model.dto.ShopCartDTO;
import pe.edu.vallegrande.ecommerce.model.dto.ShoppingCartDTO;
import pe.edu.vallegrande.ecommerce.model.entity.ShoppingCart;

import java.util.List;
import java.util.Optional;

public interface ShoppingCartService {
    List<ShoppingCart> findByUser(Long userId);

    ShoppingCart create(ShoppingCartDTO dto);

    ShoppingCart update(Long id, ShoppingCartDTO dto);

    Optional<ShoppingCart> adjust(Integer qty, ShopCartDTO dto);

    void deleteById(Long id);
}
