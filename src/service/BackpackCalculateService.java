package service;

import dto.request.service.CalculateRequest;
import dto.response.service.CalculateResponse;
import model.ItemSet;

public class BackpackCalculateService {     //교수님 화이팅
    public CalculateResponse calculate(CalculateRequest request) {
        int numberOfItem = request.getItemSetSize();
        int backpackSize = request.getBackpackSize();
        ItemSet itemSet = request.getItemSet();
        int[][] storage = new int[numberOfItem + 1][backpackSize + 1];

        //가치 계산 알고리즘
        for (int itemId = 0; itemId <= numberOfItem; itemId++) {
            for (int backpackWeight = 0; backpackWeight <= backpackSize; backpackWeight++) {
                if (itemId == 0 || backpackWeight == 0) {
                    storage[itemId][backpackWeight] = 0;
                } else if (itemSet.getItem(itemId - 1).getWeight() > backpackWeight) {
                    storage[itemId][backpackWeight] = storage[itemId - 1][backpackWeight];
                } else {
                    storage[itemId][backpackWeight] = Math.max(storage[itemId - 1][backpackWeight],
                            itemSet.getItem(itemId - 1).getValue() + storage[itemId - 1][backpackWeight - itemSet.getItem(itemId - 1).getWeight()]);
                }
            }
        }

        //담긴 아이템 수 알고리즘
        int notPutInItem = numberOfItem;
        int leftSizeOfBackpack = backpackSize;
        int putItemCount = 0;
        while (notPutInItem > 0 && leftSizeOfBackpack > 0) {
            if (storage[notPutInItem][leftSizeOfBackpack] != storage[notPutInItem - 1][leftSizeOfBackpack]) {
                putItemCount++;
                leftSizeOfBackpack -= itemSet.getItem(notPutInItem - 1).getWeight();
            }
            notPutInItem--;
        }

        return new CalculateResponse(
                putItemCount,
                backpackSize - leftSizeOfBackpack,
                storage[numberOfItem][backpackSize]
        );
    }
}