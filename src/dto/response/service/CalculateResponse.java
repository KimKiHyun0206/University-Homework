package dto.response.service;

import model.CalculateResult;
import model.Item;

import java.util.List;

public class CalculateResponse {
    private final List<Item> items;
    private final int weight;
    private final int numberOfItem;

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

    public static CalculateResponse from(CalculateResult result){
        return new CalculateResponse(
                result.getItems(),
                result.getWeight(),
                result.getNumberOfItem()
        );
    }
}