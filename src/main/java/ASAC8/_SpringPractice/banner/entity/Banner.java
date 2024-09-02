package ASAC8._SpringPractice.banner.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity // 너와 나의 연결고리 = Entity <=> Database Table 연결
@Table(name = "banner")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Banner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String title;

    @Column(name = "image_url")
    private String imageUrl;

    public Banner(String title, String imageUrl) {
        this.title = title;
        this.imageUrl = imageUrl;
    }

    public Banner(Integer id, String title, String imageUrl) {
        this.id = id;
        this.title = title;
        this.imageUrl = imageUrl;
    }

    //도메인의 값을 바꾸는 메서드 만들기       컨벤션 네이버 구글 두개 많이씀 네이버 컨벤션이 국룰이다
    public void changeBannerItems(String title, String imageUrl) {
        this.title = title;
        this.imageUrl = imageUrl;
    }

    //도메인의 값을 바꾸는 메서드 만들기       컨벤션 네이버 구글 두개 많이씀 네이버 컨벤션이 국룰이다
    public void changeBannerItems2(BannerReqDto.BannerDefaultReqDto dto) {
        this.title = dto.title();
        this.imageUrl = dto.imageUrl();
    }
}
