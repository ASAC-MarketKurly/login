package ASAC8._SpringPractice.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

// 역할과 책임의 분리 : 책임분리
// - CustomExceptionHandler : 에러 중앙 처리
// - NewProductItemsController : 고객 반응 신상품 반환등 API 제공
//

@Slf4j              // Slf4j + log.??? 한세트라고 생각하기
@ControllerAdvice   //Controller 앞단에 있는 컨트롤러를 도와주는 애들
public class CustomExceptionHandler {

    @ExceptionHandler(value = NullPointerException.class)  // 어떤 종류의 exception 을 처리할 것인가
    public ResponseEntity<ExceptionError /* Generic 제네릭 : 어떤 클래스도 가능*/> catchNullPointerException(NullPointerException e) {    // null 은 void 타입
        log.warn("승인된 새 아이템 조회 시 null 값이 반환됐습니다.", e.fillInStackTrace());     // try catch 에서 catch 에 있는 로직을 쓴다
        return ResponseEntity
                .status(500)
                .body(ExceptionError.of(5, "NULL 에러가 발생했습니다 "));
    }

    @ExceptionHandler(value = AaronException.class)
    public ResponseEntity<ExceptionError> idErrorException(AaronException e) {
        log.info("id 값에 0이 입력되는 에러가 발생했습니다.", e.fillInStackTrace());
        return ResponseEntity
                .status(400)
                .body(ExceptionError.of(2, "id 값을 다시 확인해주세요"));
    }

//    @ExceptionHandler(value = RuntimeException.class)  // 어떤 종류의 exception 을 처리할 것인가
//    public ResponseEntity<ExceptionError /* Generic 제네릭 : 어떤 클래스도 가능*/ > catchRuntimeException(RuntimeException e){    // null 은 void 타입
//        log.error("처음으로 우리가 모르는 에러가 발생했습니다", e.fillInStackTrace());     // try catch 에서 catch 에 있는 로직을 쓴다
//        return ResponseEntity
//                .status(500)
//                .body(ExceptionError.of(1, "서버팀에서 보고 있습니다"));  // 메세지 종류 1. 솔직하게 말하기 (서버가 망가지고있습니다)
//    }                                                                                //     2. 숨기는거      (서버가 점검중입니다)
}
