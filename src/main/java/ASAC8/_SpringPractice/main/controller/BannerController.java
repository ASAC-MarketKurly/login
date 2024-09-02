package ASAC8._SpringPractice.main.controller;

import ASAC8._SpringPractice.banner.entity.Banner;
import ASAC8._SpringPractice.banner.entity.BannerReqDto;
import ASAC8._SpringPractice.main.controller.response.MainItemsResponseDto;
import ASAC8._SpringPractice.main.service.BannerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/main/api")
public class BannerController {

    private final BannerService bannerService;
    // 스펙(SPEC) : 요구사항
    // API (application programming interface) -> Interface
    // Interface : 어떤 두 대상 사이에서 소통을 도와주는 어떠한 것
    // 예시 : 리모컨
    // API 스펙 != 서버 스펙 -> 클라이언트와 병목 현상이 발생하지 않음.
    // API
    // Bean -> DI, IOC 서로 필요충분 관계인가?, IOC -> 라이브러이 vs 프레임워크, DI -> 결합도, Bean -> 싱글톤 패턴 -> spring 탄생 배경
    // Entity 가 아닌 대상을 어떻게 테이블에 저장할 수 있을까? -> ElementCollection

    @PostMapping("/add")   //Restful 공부
    @ResponseStatus(HttpStatus.OK)
    public MainItemsResponseDto postMainItems() { //bannerItemCreateDto 로 필드값 재정의 해서 써야한다
        // 들어오는 값의 형태를 제어할수있따 BannerItem 클래스에 어노테이션을 써서 제어할수잇다
        return bannerService.createMain();
    }

    @GetMapping("/main-slider")
    public ResponseEntity<MainItemsResponseDto> getMainItems() {     // ResponseEntity 프론트가 상태코드를 추출할수있는데 굳이 백엔드에서 할필요가 있나?
        MainItemsResponseDto response = bannerService.getMain();

        return ResponseEntity
                .status(200)
                .body(response);
    }

    @PutMapping("/main-slider/{id}")  // Patch 공부하세요?
    public Banner updateMainItem( //requestParam 에는 디폴트 값 및 제약사항 검증 가능
                                  @PathVariable Integer id,
                                  @RequestParam String title,
                                  @RequestParam String imageUrl
    ) {
        return bannerService.updateMain(id, title, imageUrl);
    }

    @PutMapping("/main-slider") // 위에 꺼랑 같은 코드
    public Banner updateMainItem(@RequestBody BannerReqDto.BannerDefaultReqDto dto) {
        return bannerService.updateMain2(dto);
    }

    @DeleteMapping("/main-slider/{id}")
    public void deleteMainItem(@PathVariable Integer id) {
        bannerService.deleteMain(id);
    }

    @DeleteMapping("/main-slider/clear")
    public void deleteAllMainItem() {
        bannerService.clearAllMain();

//        return ResponseEntity
//                .status(200)
//                .body(response);
    }
}
