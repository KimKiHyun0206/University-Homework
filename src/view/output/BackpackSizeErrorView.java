package view.output;

import dto.request.view.output.error.BackpackSizeErrorViewRequest;

public class BackpackSizeErrorView {                                        //배낭의 무게가 잘못 되었음을 알려주기 위한 View
    public void alertSizeError(BackpackSizeErrorViewRequest request) {      //배낭의 무게가 잘못 되었음을 알려주기 위한 메소드
        System.out.println("[ Error ] 배낭의 사이즈가 " + request.getSize() + "로 잘못 입력되었습니다");
    }
}