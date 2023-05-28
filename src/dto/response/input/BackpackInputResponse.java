package dto.response.input;

public class BackpackInputResponse {
    private final int backpackSize;

    public BackpackInputResponse(int backpackSize) {
        this.backpackSize = backpackSize;
    }

    public int getBackpackSize() {
        return backpackSize;
    }

    public static BackpackInputResponse from(int backpackSize){
        return new BackpackInputResponse(backpackSize);
    }
}