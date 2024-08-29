package ASAC8._SpringPractice.main.service;

import ASAC8._SpringPractice.banner.entity.Banner;
import ASAC8._SpringPractice.banner.repository.BannerRepository;
import ASAC8._SpringPractice.item.*;
import ASAC8._SpringPractice.main.controller.response.MainItemsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MainService {

//    private final BannerItemRepository bannerItemRepository;
    private final BannerRepository bannerRepository;

    class BannerCreateRequestDto {
        private String title;
        private String imageUrl;

        public Banner toEntity() {
            return new Banner(title, imageUrl);
        }
    }

    public MainItemsResponseDto createMain (BannerCreateRequestDto request) {
        bannerRepository.save(request.toEntity()/* Banner */);
        List<Banner> addedBanners = bannerRepository.findAll();
        List<MainItem> response = addedBanners.stream()
                .map(MainItem::of)
                .toList();

        return MainItemsResponseDto.of(response);
    }

    public MainItemsResponseDto getMain(){
        List<Banner> banners = bannerRepository.findAll();
        List<MainItem> response = banners.stream()
                .map(MainItem::of)
                .toList();

        return MainItemsResponseDto.of(response);
    }

    public MainItem updateMain (Integer id, String title, String imageUrl) {
        Optional<Banner> wrappedBanner = bannerRepository.findById(id);
        Banner banner = wrappedBanner.orElseThrow(() -> new RuntimeException("데이터가 없어요. banner_id : " + id));

        banner.setTitle(title);
        banner.setImageUrl(imageUrl);

        Banner updatedBanner = bannerRepository.save(banner);
        return MainItem.of(updatedBanner);
    }

    public void deleteMain (Integer id) {
        bannerRepository.deleteById(id);
    }

    public void clearMain () {
        bannerRepository.deleteAll();
    }
}
