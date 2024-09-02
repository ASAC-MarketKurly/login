package ASAC8._SpringPractice.main.dto;

import lombok.Data;

@Data
public class BannerCreateRequestDto { // 역직렬화 , 직렬화
    private final String title;
    private final String imageUrl;
}
