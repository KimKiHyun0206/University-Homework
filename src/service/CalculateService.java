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
        CalculateResult calculateResult = new CalculateResult();    //모든 값이 0인 DefaultResult
        List<Item> useItem = new LinkedList<>();
        ItemSet itemSet = request.getItemSet();

        useItem.add(itemSet.getItem(0));
        for (int i = 0; i < request.getItemSet().getItemSetSize(); i++) {
            CalculateResult instanceCalculateResult = new CalculateResult();

            for (int j = 1; j < request.getBackpackSize() + 1; j++) {
                int backpackSize = j;

                for (int k = useItem.size() - 1; k >= 0; k--) {     //크기가 작은 것부터 비교하기 위해 뒤에서부터 시작함
                    //System.out.print("물건 비교 : " + useItem.get(k).getId() + " ");
                    if (useItem.get(k).getWeight() <= backpackSize) {
                        instanceCalculateResult.addItem(useItem.get(k), j);
                        backpackSize -= useItem.get(k).getWeight();
                    }
                }
                calculateResult = compareValue(calculateResult, instanceCalculateResult, request.getBackpackSize());
                //System.out.println("  info : useItemNumber " + (i + 1) + ", backpackSize " + j + " = " + instanceCalculateResult.getValue());
            }
            if (i < request.getItemSet().getItemSetSize() - 1) {
                useItem.add(itemSet.getItem(i + 1));
            }
        }

        return CalculateResponse.from(calculateResult);
    }

    private CalculateResult compareValue(CalculateResult oldValue, CalculateResult newValue, int backpackSize) {
        if (
                isNewValueIsMoreExpensive(oldValue, newValue) && isNewValueWeightValidate(newValue, backpackSize)
        ) {
            return newValue;
        }
        return oldValue;
    }

    private boolean isNewValueIsMoreExpensive(CalculateResult oldValue, CalculateResult newValue) {
        return oldValue.getValue() < newValue.getValue();
    }

    private boolean isNewValueWeightValidate(CalculateResult newValue, int backpackSize) {
        return newValue.getWeight() <= backpackSize;
    }
}