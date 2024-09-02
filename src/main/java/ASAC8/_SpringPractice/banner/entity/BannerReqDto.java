package ASAC8._SpringPractice.banner.entity;

public record BannerReqDto(
) {
    public record BannerDefaultReqDto(
            Integer id,
            String title,
            String imageUrl
    ) {

    }
}
