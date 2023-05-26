package dto.request.view.output;

public class BackpackSizeErrorViewRequest {
    private final int size;

    public BackpackSizeErrorViewRequest(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }
}