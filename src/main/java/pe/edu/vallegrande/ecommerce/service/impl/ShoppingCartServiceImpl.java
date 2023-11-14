package pe.edu.vallegrande.ecommerce.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.vallegrande.ecommerce.exception.NotFoundException;
import pe.edu.vallegrande.ecommerce.model.dto.ShopCartDTO;
import pe.edu.vallegrande.ecommerce.model.dto.ShoppingCartDTO;
import pe.edu.vallegrande.ecommerce.model.entity.ShoppingCart;
import pe.edu.vallegrande.ecommerce.model.mapper.ShoppingCartMapper;
import pe.edu.vallegrande.ecommerce.repository.ShoppingCartRepository;
import pe.edu.vallegrande.ecommerce.service.ShoppingCartService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ShoppingCartServiceImpl implements ShoppingCartService {

    private final ShoppingCartMapper shoppingCartMapper;
    private final ShoppingCartRepository shoppingCartRepository;

    @Override
    public List<ShoppingCart> findByUser(Long userId) {
        return shoppingCartRepository.findAllByUserId(userId);
    }

    @Override
    public ShoppingCart create(ShoppingCartDTO dto) {
        return shoppingCartRepository.save(shoppingCartMapper.toEntity(dto));
    }

    @Override
    public ShoppingCart update(Long id, ShoppingCartDTO dto) {
        return shoppingCartRepository.findById(id)
                .map(cart -> shoppingCartRepository.save(shoppingCartMapper.partialUpdate(dto, cart)))
                .orElseThrow(() -> new NotFoundException("Shopping cart item not found"));
    }

    @Override
    public Optional<ShoppingCart> adjust(Integer qty, ShopCartDTO dto) {
        return shoppingCartRepository.findOneByUserIdAndProductId(dto.getUserId(), dto.getProductId())
                .map(cart -> {
                    final int quantity = cart.getQuantity() + qty;
                    cart.setQuantity(quantity);
                    return adjustmentItem(quantity, cart);
                })
                .orElseGet(() -> adjustmentItem(qty, shoppingCartMapper.toEntity(dto)));
    }

    @Override
    public void deleteById(Long id) {
        shoppingCartRepository.deleteById(id);
    }

    private Optional<ShoppingCart> adjustmentItem(Integer quantity, ShoppingCart entity) {
        if (quantity <= 0) {
            Optional.ofNullable(entity.getId())
                    .ifPresent(res -> shoppingCartRepository.deleteById(entity.getId()));
            return Optional.empty();
        }
        return Optional.of(shoppingCartRepository.save(entity));
    }

}
