package ASAC8._SpringPractice.item;

import ASAC8._SpringPractice.banner.entity.Banner;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MainItem {
    private Integer id;
    private String title;
    private String imageUrl;

    public static MainItem of(Banner banner){
        return new MainItem(
                banner.getId(),
                banner.getTitle(),
                banner.getImageUrl()
        );
    }
}
