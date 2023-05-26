package dto.request.view.input;

public class ItemInputRequest {
    private final int numberOfItem;

    public ItemInputRequest(int numberOfItem) {
        this.numberOfItem = numberOfItem;
    }

    public int getNumberOfItem() {
        return numberOfItem;
    }
}