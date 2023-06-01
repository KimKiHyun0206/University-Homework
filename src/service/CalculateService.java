package service;

import dto.request.service.CalculateRequest;
import dto.response.service.CalculateResponse;
import model.CalculateResult;
import model.Item;
import model.ItemSet;

import java.util.LinkedList;
import java.util.List;

public class CalculateService {
    public CalculateResponse calculate(CalculateRequest request) {
        CalculateResult calculateResult = new CalculateResult();                                                 //모든 값이 0인 DefaultResult
        List<Item> useItem = new LinkedList<>();
        ItemSet itemSet = request.getItemSet();

        useItem.add(itemSet.getItem(0));
        for (int numberOfItem = 0; numberOfItem < request.getItemSet().getItemSetSize(); numberOfItem++) {
            CalculateResult instanceCalculateResult = new CalculateResult();

            for (int backpackSize = 1; backpackSize < request.getBackpackSize() + 1; backpackSize++) {
                int instanceBackpackSize = backpackSize;

                for (int compareItemId = useItem.size() - 1; compareItemId >= 0; compareItemId--) {              //크기가 작은 것부터 비교하기 위해 뒤에서부터 시작함
                    if (useItem.get(compareItemId).getWeight() <= instanceBackpackSize) {
                        instanceCalculateResult.addItem(useItem.get(compareItemId), backpackSize);
                        instanceBackpackSize -= useItem.get(compareItemId).getWeight();
                    }
                }
                calculateResult = compareValue(calculateResult, instanceCalculateResult, request.getBackpackSize());
            }
            if (numberOfItem < request.getItemSet().getItemSetSize() - 1) {
                useItem.add(itemSet.getItem(numberOfItem + 1));
            }
        }

        return CalculateResponse.from(calculateResult);
    }

    private CalculateResult compareValue(CalculateResult oldResult, CalculateResult newResult, int backpackSize) {
        if (
                isNewValueIsMoreExpensive(oldResult, newResult) && isNewValueWeightValidate(newResult, backpackSize)
        ) {
            return newResult;
        }
        return oldResult;
    }

    private boolean isNewValueIsMoreExpensive(CalculateResult oldResult, CalculateResult newResult) {
        return oldResult.getValue() < newResult.getValue();
    }

    private boolean isNewValueWeightValidate(CalculateResult newResult, int backpackSize) {
        return newResult.getAllItemsWeight() <= backpackSize;
    }
}