package service;

import dto.request.service.CalculateRequest;
import dto.response.service.CalculateResponse;
import model.CalculateResult;
import model.Item;
import model.ItemSet;

import java.util.*;

//https://wikidocs.net/170954
public class NewCalculateService {
    public CalculateResponse calculate(CalculateRequest request) {         //모든 값이 0인 DefaultResult
        ItemSet itemSet = request.getItemSet();
        int requestBackpackSize = request.getBackpackSize();
        CalculateResult[][] storage = makeStorage(requestBackpackSize, itemSet.getItemSetSize());


        for (int i = 1; i < itemSet.getItemSetSize(); i++) {
            Item item = itemSet.getItem(i);
            boolean isItemNotUsed = true;
            int leftWeight = 0;
            for (int backpackSize = 0; backpackSize < requestBackpackSize; backpackSize++) {
                storage[i][backpackSize] = storage[i-1][backpackSize];
                if(backpackSize <= item.getWeight()){
                    storage[i][backpackSize] = compare(storage[i][backpackSize], storage[i-1][backpackSize - item.getWeight()]);
                }
            }
        }

        return CalculateResponse.from(findMaxValue(storage, requestBackpackSize));
    }

    private CalculateResult[][] makeStorage(int x, int y) {
        CalculateResult[][] storage = new CalculateResult[y][x];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; y++) {
                storage[j][i] = new CalculateResult();
            }
        }
        return storage;
    }

    private CalculateResult findMaxValue(CalculateResult[][] storage, int leftWeight) {
        CalculateResult result = new CalculateResult();
        for (int i = 0; i < storage.length; i++) {
            if (storage[i][leftWeight].getValue() < result.getValue()) {
                result = storage[i][leftWeight];
            }
        }

        return result;
    }

    private CalculateResult compare(CalculateResult a, CalculateResult b){
        if(a.getValue() > b.getValue()){
            return a;
        }
        return b;
    }
}