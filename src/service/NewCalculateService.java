package service;

import dto.request.service.CalculateRequest;
import dto.response.service.CalculateResponse;
import model.Item;

//https://wikidocs.net/170954
public class NewCalculateService {
    public CalculateResponse calculate(CalculateRequest request) {
        int[][] calculateStorage = new int[request.getItemSet().getItemSetSize() + 1][request.getBackpackSize() + 1];
        for (int i = 1; i <= request.getItemSet().getItemSetSize(); i++) {
            Item instanceItem = request.getItemSet().getItem(i);
            int weight = instanceItem.getWeight();
            int value = instanceItem.getValue();
            for (int j = 1; j <= request.getBackpackSize(); j++) {
                if (weight <= j) {
                    calculateStorage[i][j] = Math.max(calculateStorage[i - 1][j], calculateStorage[i - 1][j - weight] + value);
                } else {
                    calculateStorage[i][j] = calculateStorage[i - 1][j];
                }
            }
        }
        return null;
    }
}