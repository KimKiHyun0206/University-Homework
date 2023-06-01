package model;

import dto.request.view.output.error.BackpackSizeErrorViewRequest;
import view.output.BackpackSizeErrorView;

public class Backpack {         //배낭에 대한 정보를 담고 있는 Model
    private final int size;     //배낭의 크기

    public Backpack(int size) {
        this.size = backpackSizeValidation(size);
    }

    private int backpackSizeValidation(int size) {          //배낭 용량을 검사한다
        if (size < 50 | size > 100) {
            new BackpackSizeErrorView().alertSizeError(
                    BackpackSizeErrorViewRequest.from(size)
            );
            System.exit(0);                           //에러 검출 시 프로그램 종료
        }
        return size;
    }

    public int getSize() {
        return size;
    }
}