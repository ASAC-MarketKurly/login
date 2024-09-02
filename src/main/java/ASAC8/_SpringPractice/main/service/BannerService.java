package ASAC8._SpringPractice.main.service;

import ASAC8._SpringPractice.banner.entity.Banner;
import ASAC8._SpringPractice.banner.entity.BannerReqDto;
import ASAC8._SpringPractice.banner.repository.BannerRepository;
import ASAC8._SpringPractice.item.BannerItem;
import ASAC8._SpringPractice.item.MainItem;
import ASAC8._SpringPractice.main.controller.response.MainItemsResponseDto;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BannerService {

    //    private final BannerItemRepository bannerItemRepository;
    private final BannerRepository bannerRepository;

//    class BannerCreateRequestDto {
//        private String title;
//        private String imageUrl;
//
//        public Banner toEntity() {
//            return new Banner(title, imageUrl);
//        }
//    }

    @PostConstruct
    public void init() {
        var banners = List.of(
                new Banner(1, "1", "https://product-image.kurly.com/hdims/resize/%3E1900x%3E370/quality/85/src/banner/main/pc/img/e8a7168a-d665-4795-9fa0-2b9bcff17c7e.png"),
                new Banner(2, "2", "https://product-image.kurly.com/hdims/resize/%3E1900x%3E370/quality/85/src/banner/main/pc/img/4d291636-7ebb-4456-af0c-1a876e3c684f.jpg"),
                new Banner(3, "3", "https://product-image.kurly.com/hdims/resize/%3E1900x%3E370/quality/85/src/banner/main/pc/img/42d0f8fb-f260-4271-bf81-e3ed3c8f5d5c.jpg"),
                new Banner(4, "4", "https://product-image.kurly.com/hdims/resize/%3E1900x%3E370/quality/85/src/banner/main/pc/img/f8b00656-8daa-4ce3-834b-03c55e61f978.jpg"),
                new Banner(5, "5", "https://product-image.kurly.com/hdims/resize/%3E1900x%3E370/quality/85/src/banner/main/pc/img/f3b2cf48-6ca0-4c1b-8f98-575d5750a611.jpg"),
                new Banner(6, "6", "https://product-image.kurly.com/hdims/resize/%3E1900x%3E370/quality/85/src/banner/main/pc/img/e6d37a73-2a7c-4507-9e53-c2cfa484a5db.jpg"),
                new Banner(7, "7", "https://product-image.kurly.com/hdims/resize/%3E1900x%3E370/quality/85/src/banner/main/pc/img/8d0d5488-376a-4873-841d-1aea56caad8c.jpg"),
                new Banner(8, "8", "https://product-image.kurly.com/hdims/resize/%3E1900x%3E370/quality/85/src/banner/main/pc/img/16fbbddd-42f0-4a67-a15b-0aec0ef74e87.jpg")
        );
        bannerRepository.saveAll(banners);
    }

    public MainItemsResponseDto createMain() {
        var bannerItems = List.of(
                BannerItem.of(
                        1,
                        "1",
                        "https://product-image.kurly.com/hdims/resize/%3E1900x%3E370/quality/85/src/banner/main/pc/img/e8a7168a-d665-4795-9fa0-2b9bcff17c7e.png"
                ),
                BannerItem.of(
                        2,
                        "2",
                        "https://product-image.kurly.com/hdims/resize/%3E1900x%3E370/quality/85/src/banner/main/pc/img/4d291636-7ebb-4456-af0c-1a876e3c684f.jpg"
                ),
                BannerItem.of(
                        3,
                        "3",
                        "https://product-image.kurly.com/hdims/resize/%3E1900x%3E370/quality/85/src/banner/main/pc/img/42d0f8fb-f260-4271-bf81-e3ed3c8f5d5c.jpg"

                ),
                BannerItem.of(
                        4,
                        "4",
                        "https://product-image.kurly.com/hdims/resize/%3E1900x%3E370/quality/85/src/banner/main/pc/img/f8b00656-8daa-4ce3-834b-03c55e61f978.jpg"

                ),
                BannerItem.of(
                        5,
                        "5",
                        "https://product-image.kurly.com/hdims/resize/%3E1900x%3E370/quality/85/src/banner/main/pc/img/f3b2cf48-6ca0-4c1b-8f98-575d5750a611.jpg"

                ),
                BannerItem.of(
                        6,
                        "6",
                        "https://product-image.kurly.com/hdims/resize/%3E1900x%3E370/quality/85/src/banner/main/pc/img/e6d37a73-2a7c-4507-9e53-c2cfa484a5db.jpg"

                ),
                BannerItem.of(
                        7,
                        "7",
                        "https://product-image.kurly.com/hdims/resize/%3E1900x%3E370/quality/85/src/banner/main/pc/img/8d0d5488-376a-4873-841d-1aea56caad8c.jpg"

                ),
                BannerItem.of(
                        8,
                        "8",
                        "https://product-image.kurly.com/hdims/resize/%3E1900x%3E370/quality/85/src/banner/main/pc/img/16fbbddd-42f0-4a67-a15b-0aec0ef74e87.jpg"
                )
        );

        var banners = bannerItems.stream()
                .map(bannerItem -> new Banner(bannerItem.getTitle(), bannerItem.getImageUrl()))
                .toList();

//        bannerRepository.saveAll(banners);             // 빌더 패턴을 지양하는 이유 : nullsafe 하지않다 빌터패턴으로 생성했을때는 null 이된다
        List<Banner> addedBanners = bannerRepository.saveAll(banners);    // 컬럼 10개가 잇는 엔티티를 만들면 어떤건 8개 어떤건 7개 들어가는데 빌더패턴을 쓰면 휴먼에러가 일어난다
        List<MainItem> response = addedBanners.stream()// 생성자를 사용했을때 컴파일러에 도움을 받을 수 있다 빌더패턴은 컴파일러의 도움을 받을수 없다
                .map(MainItem::of)
                .toList();

        return MainItemsResponseDto.of(response);   // 정적 팩토리 메서드를 쓰려면 이유가 있어야한다
//        return new MainItemsResponseDto()
    }

    public MainItemsResponseDto getMain() {
        List<Banner> banners = bannerRepository.findAll();
        List<MainItem> response = banners.stream()
                .map(MainItem::of)
                .toList();

        return MainItemsResponseDto.of(response);
    }

    @Transactional //두개 차이점 공부 jpa의 1차 체킹과 더티체킹에 대해서 공부
    public Banner updateMain(Integer id, String title, String imageUrl) {
        Banner wrappedBanner = bannerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("데이터가 없어요. banner_id : " + id));

        wrappedBanner.changeBannerItems(title, imageUrl);  //setter 안쓰는 이유 의미 데이터를 셋업한다는 의미 저거를 여기저기서 갖다쓰면 변경을 추적하기 힘들기 때문에 쓰지말라

        return wrappedBanner;
    }

    @Transactional //위에 업데이트랑 같은 코드
    public Banner updateMain2(BannerReqDto.BannerDefaultReqDto dto) {
        Banner wrappedBanner = bannerRepository.findById(dto.id())
                .orElseThrow(() -> new RuntimeException("데이터가 없어요. banner_id : " + dto.id()));

        wrappedBanner.changeBannerItems2(dto);  //setter 안쓰는 이유 의미 데이터를 셋업한다는 의미 저거를 여기저기서 갖다쓰면 변경을 추적하기 힘들기 때문에 쓰지말라

        return wrappedBanner;
    }

    public void deleteMain(Integer id) {
        bannerRepository.deleteById(id);
    }

    public void clearAllMain() {
        bannerRepository.deleteAll();
    }
}
