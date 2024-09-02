package ASAC8._SpringPractice.item;

import ASAC8._SpringPractice.exception.AaronException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class BannerItemRepository {

    List<BannerItem> bannerItems =
            new ArrayList<>(
                    Arrays.asList(
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
                    )
            );

    public List<BannerItem> getAllItems() {     // 위에 저장한 ItemList 를 반환하는 메서드 getAllItems 메서드 이름도 의미 있게 !
        return new ArrayList<>(bannerItems);  // 데이터를 ArrayList 에 넣어주기
    }

    public List<BannerItem> addBannerItem(BannerItem bannerItem) {
        bannerItems.add(bannerItem);

        return bannerItems;
    }

    public BannerItem updateBannerItem(Integer id, String title, String imageUrl) {
        if (id == 0) {
            throw new AaronException("Client 측에서 id 값에 0을 넣는 에러발생");
        }

        BannerItem bannerItem = bannerItems.get(id - 1);
        bannerItem.setId(id);
        bannerItem.setTitle(title);
        bannerItem.setImageUrl(imageUrl);

        return bannerItem;
    }

    public BannerItem deleteBannerItem(Integer id) {

        BannerItem RemoveBannerItem = bannerItems.get(id - 1);

        if (RemoveBannerItem != null) {
            bannerItems.remove(id - 1);
        } else {
            throw new RuntimeException();
        }

        return RemoveBannerItem;
    }

    public List<BannerItem> deleteAllBannerItem() {
        bannerItems.clear();

        return bannerItems;
    }
}
