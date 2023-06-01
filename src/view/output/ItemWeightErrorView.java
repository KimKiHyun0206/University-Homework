package view.output;

import dto.request.view.output.error.ItemWeightErrorViewRequest;

public class ItemWeightErrorView {                              //Item 의 무게가 잘못 되었음을 알려주기 위한 View
    public void alert(ItemWeightErrorViewRequest request) {     //Item 의 무게가 잘못 되었음을 알려주기 위한 메소드
        System.out.println("[ Error ] 아이템의 무게가 10~50을 벗어났습니다, 무게 : " + request.getWeight());
    }
}