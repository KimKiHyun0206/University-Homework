package dto.response.service;

import model.CalculateResult;
import model.Item;

import java.util.List;

public class CalculateResponse {        //계산 결과를 알리기 위한 Response DTO
    private final List<Item> items;     //선택된 Item 들
    private final int weight;           //배낭의 무게
    private final int numberOfItem;     //들어간 아이템의 갯수

    public CalculateResponse(List<Item> items, int weight, int numberOfItem) {
        this.items = items;
        this.weight = weight;
        this.numberOfItem = numberOfItem;
    }

    public List<Item> getItems() {
        return items;
    }

    public int getWeight() {
        return weight;
    }

    public int getNumberOfItem() {
        return numberOfItem;
    }


    /*
    한 번에 객체를 매핑하기 위한 매핑 메소드
    CalculateResponse 에 필요한 정보들을 받아서 매핑해준다
    */
    public static CalculateResponse from(CalculateResult result) {
        return new CalculateResponse(
                result.getItems(),
                result.getAllItemsWeight(),
                result.getNumberOfItem()
        );
    }
}