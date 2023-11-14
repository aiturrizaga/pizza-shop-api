package pe.edu.vallegrande.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import pe.edu.vallegrande.ecommerce.model.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Modifying
    @Query(value = "update Category c set c.active = false where c.id = ?1")
    void disableById(Long id);
}
