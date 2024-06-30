package pe.edu.vallegrande.ecommerce.service;

import org.springframework.data.domain.Pageable;
import pe.edu.vallegrande.ecommerce.model.dto.OrderDTO;
import pe.edu.vallegrande.ecommerce.model.dto.PageableDTO;
import pe.edu.vallegrande.ecommerce.model.entity.Order;

import java.util.Optional;

public interface OrderService {
    Order create(OrderDTO dto);

    PageableDTO<Order> findAll(Pageable pageable);

    Optional<Order> findById(Long id);
}
