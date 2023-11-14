package pe.edu.vallegrande.ecommerce.service;

import pe.edu.vallegrande.ecommerce.model.dto.BannerDTO;
import pe.edu.vallegrande.ecommerce.model.entity.Banner;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface BannerService {
    Optional<Banner> findById(Long id);

    List<Banner> searchByDate(String startDate, String endDate);

    Banner create(BannerDTO dto);

    Banner update(Long id, BannerDTO dto);

    void disableById(Long id);
}
