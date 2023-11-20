package pe.edu.vallegrande.ecommerce.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.vallegrande.ecommerce.exception.NotFoundException;
import pe.edu.vallegrande.ecommerce.model.dto.BannerDTO;
import pe.edu.vallegrande.ecommerce.model.entity.Banner;
import pe.edu.vallegrande.ecommerce.model.mapper.BannerMapper;
import pe.edu.vallegrande.ecommerce.repository.BannerRepository;
import pe.edu.vallegrande.ecommerce.service.BannerService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BannerServiceImpl implements BannerService {

    private final BannerMapper bannerMapper;
    private final BannerRepository bannerRepository;

    @Override
    public Optional<Banner> findById(Long id) {
        return bannerRepository.findById(id);
    }

    @Override
    public List<Banner> searchByDate(String startDate, String endDate) {
        LocalDateTime startDateTime = LocalDateTime.parse(String.format("%sT00:00:00.000", startDate));
        LocalDateTime endDateTime = LocalDateTime.parse(String.format("%sT23:59:59.999", endDate));
        return bannerRepository.searchByDate(startDateTime, endDateTime);
    }

    @Override
    public Banner create(BannerDTO dto) {
        return bannerRepository.save(bannerMapper.toEntity(dto));
    }

    @Override
    public Banner update(Long id, BannerDTO dto) {
        return bannerRepository.findById(id)
                .map(banner -> bannerRepository.save(bannerMapper.partialUpdate(dto, banner)))
                .orElseThrow(() -> new NotFoundException("Banner not found"));
    }

    @Transactional
    @Override
    public void disableById(Long id) {
        bannerRepository.disableById(id);
    }
}
