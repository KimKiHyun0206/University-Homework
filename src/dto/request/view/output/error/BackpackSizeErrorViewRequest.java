package dto.request.view.output.error;

import view.output.BackpackSizeErrorView;

public class BackpackSizeErrorViewRequest {     //에러 발생을 알리기 휘한 DTO
    private final int size;                     //잘못 입력된 배낭 크기에 대한 정보를 담고 있다.

    public BackpackSizeErrorViewRequest(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    /*
    한 번에 객체를 매핑하기 위한 매핑 메소드
    BackpackSizeErrorViewRequest 에 필요한 정보들을 받아서 매핑해준다
    */
    public static BackpackSizeErrorViewRequest from(int size){
        return new BackpackSizeErrorViewRequest(size);
    }
}