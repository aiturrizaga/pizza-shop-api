package pe.edu.vallegrande.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.vallegrande.ecommerce.model.entity.ShoppingCart;

import java.util.List;
import java.util.Optional;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {
    Optional<ShoppingCart> findOneByUserIdAndProductId(Long userId, Long productId);

    List<ShoppingCart> findAllByUserId(Long id);
}
