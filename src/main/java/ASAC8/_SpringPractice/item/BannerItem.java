package ASAC8._SpringPractice.item;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@ToString
@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class BannerItem {
    private Integer id;
    private String title;
    private String imageUrl;

    public static BannerItem of(Integer id,
                                String title,
                                String imageUrl) {
        return new BannerItem(
                id,
                title,
                imageUrl
        );
    }
}