package model;

import dto.request.view.output.error.ItemWeightErrorViewRequest;
import view.output.ItemWeightErrorView;

public class Item {
    private final int id;                           //Item 의 id
    private final int weight;                       //Item 의 무게
    private final int value;                        //Item 의 가치

    public Item(int id, int weight, int value) {
        this.id = id;
        this.weight = weightValidation(weight);
        this.value = value;
    }

    private int weightValidation(int weight) {      //무게가 유효한지 검사한다
        if (weight > 50 | weight < 10) {
            new ItemWeightErrorView().alert(
                    ItemWeightErrorViewRequest.from(weight)
            );
            System.exit(0);                   //만약 유효하지 않을 시 프로그램 종료
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
        return "Id : " + id + "\t Weight : " + weight + "\t Value : " + value;
    }
}