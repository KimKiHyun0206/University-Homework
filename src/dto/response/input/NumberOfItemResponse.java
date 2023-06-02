package dto.response.input;

public class NumberOfItemResponse {
    private final int numberOfItem;

    public NumberOfItemResponse(int numberOfItem) {
        this.numberOfItem = numberOfItem;
    }

    public int getNumberOfItem() {
        return numberOfItem;
    }
}
