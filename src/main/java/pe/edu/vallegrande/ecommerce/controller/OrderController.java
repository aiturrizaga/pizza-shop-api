package pe.edu.vallegrande.ecommerce.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import pe.edu.vallegrande.ecommerce.model.dto.OrderDTO;
import pe.edu.vallegrande.ecommerce.model.entity.Order;
import pe.edu.vallegrande.ecommerce.service.OrderService;

import java.net.URI;
import java.util.Optional;

@RestController
@Tag(name = "Order")
@RequiredArgsConstructor
@RequestMapping("/v1/orders")
public class OrderController {

    private final OrderService orderService;

    @Operation(summary = "Get order by id")
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Order>> getOrder(@PathVariable Long id) {
        return ResponseEntity.ok(orderService.findById(id));
    }

    @Operation(summary = "Create new order")
    @PostMapping
    public ResponseEntity<Order> saveOrder(@RequestBody OrderDTO order) {
        Order response = orderService.create(order);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(response.getId())
                .toUri();
        return ResponseEntity.created(location).body(response);
    }
}
