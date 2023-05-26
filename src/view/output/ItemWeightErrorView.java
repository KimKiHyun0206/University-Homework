package view.output;

import dto.request.view.output.ItemWeightErrorViewRequest;

public class ItemWeightErrorView {
    public void alert(ItemWeightErrorViewRequest request){
        System.out.println("[ Error ] 아이템의 무게가 10~50을 벗어났습니다, 무게 : " + request.getWeight());
        System.exit(0);
    }
}