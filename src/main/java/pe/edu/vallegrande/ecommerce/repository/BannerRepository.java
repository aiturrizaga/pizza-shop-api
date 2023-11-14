package pe.edu.vallegrande.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import pe.edu.vallegrande.ecommerce.model.entity.Banner;

import java.time.LocalDateTime;
import java.util.List;

public interface BannerRepository extends JpaRepository<Banner, Long> {

    @Query(value = "from Banner b where b.active = true and (b.startDate between ?1 and ?2)")
    List<Banner> searchByDate(LocalDateTime startDate, LocalDateTime endDate);

    @Modifying
    @Query(value = "update Banner b set b.active = false where b.id = ?1")
    void disableById(Long id);
}
