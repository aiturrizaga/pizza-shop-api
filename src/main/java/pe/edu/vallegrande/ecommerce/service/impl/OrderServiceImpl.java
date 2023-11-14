package pe.edu.vallegrande.ecommerce.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.vallegrande.ecommerce.model.dto.OrderDTO;
import pe.edu.vallegrande.ecommerce.model.entity.Order;
import pe.edu.vallegrande.ecommerce.model.entity.OrderLine;
import pe.edu.vallegrande.ecommerce.model.mapper.OrderMapper;
import pe.edu.vallegrande.ecommerce.repository.OrderRepository;
import pe.edu.vallegrande.ecommerce.repository.ProductRepository;
import pe.edu.vallegrande.ecommerce.service.OrderService;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderMapper orderMapper;
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    @Override
    public Order create(OrderDTO dto) {
        Order order = orderMapper.toEntity(dto);

        Set<OrderLine> orderLines = new HashSet<>();
        dto.getItems().forEach(item -> {
            OrderLine line = new OrderLine();
            line.setQuantity(item.getQuantity());
            productRepository.findById(item.getProductId())
                    .ifPresent(product -> {
                        line.setOrder(order);
                        line.setProduct(product);
                        line.setQuantity(item.getQuantity());
                        line.setPriceUnit(product.getPrice());
                        line.setPriceTotal(product.getPrice().multiply(BigDecimal.valueOf(item.getQuantity())));
                    });
            orderLines.add(line);
        });
        BigDecimal amountTotal = orderLines.stream()
                .map(OrderLine::getPriceTotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        order.setAmountTotal(amountTotal);
        order.setSaleDate(LocalDateTime.now());
        order.setPaymentDate(LocalDateTime.now());
        order.setOrderLines(orderLines);

        return orderRepository.save(order);
    }

    @Override
    public Optional<Order> findById(Long id) {
        return orderRepository.findById(id);
    }
}
