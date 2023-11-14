package pe.edu.vallegrande.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import pe.edu.vallegrande.ecommerce.model.entity.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "from Product p where lower(p.name) like %?1% and p.active = true")
    List<Product> searchByName(String name);

    @Modifying
    @Query(value = "update Product p set p.active = false where p.id = ?1")
    void disableById(Long id);
}
