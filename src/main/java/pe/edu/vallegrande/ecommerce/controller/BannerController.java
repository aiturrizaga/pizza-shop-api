package pe.edu.vallegrande.ecommerce.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import pe.edu.vallegrande.ecommerce.model.dto.BannerDTO;
import pe.edu.vallegrande.ecommerce.model.entity.Banner;
import pe.edu.vallegrande.ecommerce.service.BannerService;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@Tag(name = "Banner")
@RequiredArgsConstructor
@RequestMapping("/v1/banners")
public class BannerController {
    private final BannerService bannerService;

    @Operation(summary = "Get banner by id")
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Banner>> getBanner(@PathVariable Long id) {
        return ResponseEntity.ok(bannerService.findById(id));
    }

    @Operation(summary = "Get banner by id")
    @GetMapping("/search")
    public ResponseEntity<List<Banner>> searchBanner(@RequestParam String startDate,
                                                     @RequestParam String endDate) {
        return ResponseEntity.ok(bannerService.searchByDate(startDate, endDate));
    }

    @Operation(summary = "Create new banner")
    @PostMapping
    public ResponseEntity<Banner> saveBanner(@RequestBody BannerDTO banner) {
        Banner response = bannerService.create(banner);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(response.getId())
                .toUri();
        return ResponseEntity.created(location).body(response);
    }

    @Operation(summary = "Update banner by id")
    @PutMapping("/{id}")
    public ResponseEntity<Banner> updateBanner(@PathVariable Long id, @RequestBody BannerDTO banner) {
        return ResponseEntity.ok(bannerService.update(id, banner));
    }

    @Operation(summary = "Disable banner by id")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> disableBanner(@PathVariable Long id) {
        bannerService.disableById(id);
        return ResponseEntity.noContent().build();
    }

}
