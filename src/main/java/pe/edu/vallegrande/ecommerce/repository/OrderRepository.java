package pe.edu.vallegrande.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.vallegrande.ecommerce.model.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
