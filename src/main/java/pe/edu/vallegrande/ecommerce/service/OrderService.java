package pe.edu.vallegrande.ecommerce.service;

import pe.edu.vallegrande.ecommerce.model.dto.OrderDTO;
import pe.edu.vallegrande.ecommerce.model.entity.Order;

import java.util.Optional;

public interface OrderService {
    Order create(OrderDTO dto);

    Optional<Order> findById(Long id);
}
