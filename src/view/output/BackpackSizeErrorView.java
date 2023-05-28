package view.output;

import dto.request.view.output.error.BackpackSizeErrorViewRequest;

public class BackpackSizeErrorView {
    public void alertSizeError(BackpackSizeErrorViewRequest request) {
        System.out.println("[ Error ] 배낭의 사이즈가 " + request.getSize() + "로 잘못 입력되었습니다");
        System.exit(0);
    }
}