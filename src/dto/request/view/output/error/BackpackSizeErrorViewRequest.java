package dto.request.view.output.error;

import view.output.BackpackSizeErrorView;

public class BackpackSizeErrorViewRequest {
    private final int size;

    public BackpackSizeErrorViewRequest(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public static BackpackSizeErrorViewRequest from(int size){
        return new BackpackSizeErrorViewRequest(size);
    }
}