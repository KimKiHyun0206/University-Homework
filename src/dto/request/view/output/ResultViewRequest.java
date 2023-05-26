package dto.request.view.output;

import dto.response.service.CalculateResponse;
import model.Item;

import java.util.List;

public class ResultViewRequest {
    private final int theNumberOfItemsInTheBackpack; //배낭에 채워진 아이템의 수
    private final int weightOfBackpack; //배낭의 현재 무게
    private final List<Item> items; //아이템 3 가지

    public ResultViewRequest(int theNumberOfItemsInTheBackpack, int weightOfBackpack, List<Item> items) {
        this.theNumberOfItemsInTheBackpack = theNumberOfItemsInTheBackpack;
        this.weightOfBackpack = weightOfBackpack;
        this.items = items;
    }

    public int getTheNumberOfItemsInTheBackpack() {
        return theNumberOfItemsInTheBackpack;
    }

    public int getWeightOfBackpack() {
        return weightOfBackpack;
    }

    public List<Item> getItems() {
        return items;
    }

    public static ResultViewRequest from(CalculateResponse response){

        return new ResultViewRequest(
                response.getNumberOfItem(),
                response.getWeight(),
                response.getItems()
        );
    }
}