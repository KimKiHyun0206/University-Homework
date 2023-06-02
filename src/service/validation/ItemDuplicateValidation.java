package service.validation;

import dto.response.input.ItemInputResponse;
import model.Item;
import view.output.ItemDuplicateErrorView;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ItemDuplicateValidation {                                      //Item 의 속성이 중복되는지 검사하기 위한 Service
    public void check(ItemInputResponse response) {
        List<Item> items = response.getItems();                             //response 로부터 items 에 대한 정보를 꺼낸다
        Set<Integer> weightCheck = new HashSet<>();                         //무게를 검사할 Set 생성
        Set<Integer> valueCheck = new HashSet<>();                          //가치를 검사할 Set 생성

        items.forEach(                                                      //각 item 들에 대한 정보를 각가의 set에 넣는다
                item -> {
                    weightCheck.add(item.getWeight());
                    valueCheck.add(item.getValue());
                }
        );

        int itemListSize = items.size();                                    //item 들의 갯수를 알아낸다

        if (itemListSize != weightCheck.size()) {                           //set 의 크기와 itemListSize 의 크기가 다르면 에러 발생
            new ItemDuplicateErrorView().alertError("무게");      //에러 발생 시 프로그램 종료
            System.exit(0);
        }
        if (itemListSize != valueCheck.size()) {
            new ItemDuplicateErrorView().alertError("가치");      //set 의 크기와 itemListSize 의 크기가 다르면 에러 발생
            System.exit(0);                                           //에러 발생 시 프로그램 종료
        }
    }
}