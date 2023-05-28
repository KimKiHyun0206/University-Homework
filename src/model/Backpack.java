package model;

import dto.request.view.output.error.BackpackSizeErrorViewRequest;
import view.output.BackpackSizeErrorView;

public class Backpack {
    private final int size;
    public Backpack(int size) {
        this.size = backpackSizeValidation(size);
    }

    private int backpackSizeValidation(int size) {          //배낭 용량을 검사한다
        if (size < 50 | size > 100) {
            new BackpackSizeErrorView().alertSizeError(
                    new BackpackSizeErrorViewRequest(size)
            );
            return 100;                                     //오류 발생 시 무게를 100으로 고정한다
        }
        return size;
    }

    public int getSize() {
        return size;
    }
}