package dto.request.view.output.error;

public class ItemWeightErrorViewRequest {
    private final int weight;

    public ItemWeightErrorViewRequest(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public static ItemWeightErrorViewRequest from(int weight){
        return new ItemWeightErrorViewRequest(weight);
    }
}