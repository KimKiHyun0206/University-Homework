package dto.response.input;

public class BackpackInputResponse {    //배낭 크기에 대한 정보를 알리기 위한 Response DTO
    private final int backpackSize;     //입력 받은 배낭의 크기

    public BackpackInputResponse(int backpackSize) {
        this.backpackSize = backpackSize;
    }

    public int getBackpackSize() {
        return backpackSize;
    }

    /*
    한 번에 객체를 매핑하기 위한 매핑 메소드
    BackpackInputResponse 에 필요한 정보들을 받아서 매핑해준다
    */
    public static BackpackInputResponse from(int backpackSize){
        return new BackpackInputResponse(backpackSize);
    }
}