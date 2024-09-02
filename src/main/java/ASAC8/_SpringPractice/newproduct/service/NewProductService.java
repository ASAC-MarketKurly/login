package ASAC8._SpringPractice.newproduct.service;

import ASAC8._SpringPractice.exception.AaronException;
import ASAC8._SpringPractice.item.Item;
import ASAC8._SpringPractice.item.ItemRepository;
import ASAC8._SpringPractice.item.NewProductItem;
import ASAC8._SpringPractice.newproduct.controller.response.NewProductItemResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@RequiredArgsConstructor
@Service
public class NewProductService {

    private final ItemRepository itemRepository;

    public NewProductItemResponseDto getNewProduct(){
//        if (true) {
//            throw new AaronException("에러 발생했다 !!");         // if true 이기때문에 무조건 발생
//        }
        List<Item> items = itemRepository.getAllItems();         // 모든 Item 객체를 가져옵니다
        List<Item> newProductItems = items.stream()                  // stream API 를 사용해서
                .filter(item -> item.getIsNew() && item.getIsBestSeller())    // isNew 와 isBestSeller 가 true 인 Item 만 필터링합니다
                .toList();
//              .filter((item)->{
//                  return item.getIsNew();
//              })

        List<NewProductItem> response = newProductItems.stream()    // 필터링된 Item 객체들을 NewProductItem 로 변환합니다
                .map(NewProductItem::of)                        // Item 객체를 받아 NewProductItem 객체로 변환하는 정적 팩토리 메서드 입니다
                .toList();         //List<Item> 에서 List<NewProductItem> 로 변환시키는 로직이 map 안에 들어가는 로직 입니다
//              .map((item)-> {
//                  return NewProductItemResponseDto.of(item)
//              })
//        NewProductItemResponseDto newProductItemResponseDto = NewProductItemResponseDto.of(response);  //body에서 가공한것을 서비스 로직으로 뺌
//
//        return newProductItemResponseDto;
        return NewProductItemResponseDto.of(response);       //throw 가 리턴을 대체하는지? 아니면 리턴 전에 throw 로 처리가 되는건지?
//        throw new NullPointerException();
//        return null;
    }
}