package dto.request.view.output;

public class ItemWeightErrorViewRequest {
    private final int weight;

    public ItemWeightErrorViewRequest(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }
}