package pe.edu.vallegrande.ecommerce.model.mapper;

import org.mapstruct.*;
import pe.edu.vallegrande.ecommerce.model.dto.BannerDTO;
import pe.edu.vallegrande.ecommerce.model.entity.Banner;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface BannerMapper {
    Banner toEntity(BannerDTO bannerDTO);

    BannerDTO toDto(Banner banner);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL)
    Banner partialUpdate(BannerDTO bannerDTO, @MappingTarget Banner banner);
}