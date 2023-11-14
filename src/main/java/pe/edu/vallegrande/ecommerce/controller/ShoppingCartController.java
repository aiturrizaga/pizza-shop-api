package pe.edu.vallegrande.ecommerce.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import pe.edu.vallegrande.ecommerce.model.dto.ShopCartDTO;
import pe.edu.vallegrande.ecommerce.model.dto.ShoppingCartDTO;
import pe.edu.vallegrande.ecommerce.model.entity.ShoppingCart;
import pe.edu.vallegrande.ecommerce.service.ShoppingCartService;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@Tag(name = "Shopping Cart")
@RequiredArgsConstructor
@RequestMapping("/v1/shopping-cart")
public class ShoppingCartController {

    private final ShoppingCartService shoppingCartService;

    @Operation(summary = "Get shopping cart by user id")
    @GetMapping("/users/{userId}")
    public ResponseEntity<List<ShoppingCart>> findByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(shoppingCartService.findByUser(userId));
    }

    @Operation(summary = "Create new shopping cart item")
    @PostMapping
    public ResponseEntity<ShoppingCart> saveShopCart(@RequestBody ShoppingCartDTO shopCart) {
        ShoppingCart response = shoppingCartService.create(shopCart);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/users/{userId}")
                .buildAndExpand(response.getUserId())
                .toUri();
        return ResponseEntity.created(location).body(response);
    }

    @Operation(summary = "Update shopping cart item")
    @PutMapping("/{id}")
    public ResponseEntity<ShoppingCart> updateCategory(@PathVariable Long id, @RequestBody ShoppingCartDTO shopCart) {
        return ResponseEntity.ok(shoppingCartService.update(id, shopCart));
    }

    @Operation(summary = "Increase quantity of shopping cart item")
    @PutMapping("/adjust/increase")
    public ResponseEntity<Optional<ShoppingCart>> increaseShopCartItem(@RequestBody ShopCartDTO shopCart) {
        return ResponseEntity.ok(shoppingCartService.adjust(1, shopCart));
    }

    @Operation(summary = "Decrease quantity of shopping cart item")
    @PutMapping("/adjust/decrease")
    public ResponseEntity<Optional<ShoppingCart>> decreaseShopCartItem(@RequestBody ShopCartDTO shopCart) {
        return ResponseEntity.ok(shoppingCartService.adjust(-1, shopCart));
    }

    @Operation(summary = "Delete shopping cart item by id")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteShopCartItem(@PathVariable Long id) {
        shoppingCartService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
