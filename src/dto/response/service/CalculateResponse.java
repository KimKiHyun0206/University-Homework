package dto.response.service;

public class CalculateResponse {        //계산 결과를 알리기 위한 Response DTO
    private final int value;     //선택된 Item 들
    private final int weight;           //배낭의 무게
    private final int numberOfItem;     //들어간 아이템의 갯수

    public CalculateResponse(int items, int weight, int numberOfItem) {
        this.value = items;
        this.weight = weight;
        this.numberOfItem = numberOfItem;
    }

    public int getValue() {
        return value;
    }

    public int getWeight() {
        return weight;
    }

    public int getNumberOfItem() {
        return numberOfItem;
    }
}