package model;

import dto.request.view.output.ItemWeightErrorViewRequest;
import view.output.ItemWeightErrorView;

public class Item {
    private final int id;
    private final int weight;
    private final int value;

    public Item(int id, int weight, int value) {
        this.id = id;
        this.weight = weightValidation(weight);
        this.value = value;
    }

    private int weightValidation(int weight) {
        if (weight > 50 | weight < 10) {
            new ItemWeightErrorView().alert(
                    new ItemWeightErrorViewRequest(weight)
            );
            return 0;
        }
        return weight;
    }

    public int getWeight() {
        return weight;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Id : " + id + ", Weight : " + weight + ", Value : " + value;
    }
}