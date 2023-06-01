package dto.request.view.output.error;

public class ItemDuplicateErrorViewRequest {        //Item 이 중복됨을 알려주기 위한 DTO
    private final int duplicateId;                  //중복된 ID의 값

    public ItemDuplicateErrorViewRequest(int duplicateId) {
        this.duplicateId = duplicateId;
    }

    public int getDuplicateId() {
        return duplicateId;
    }

    /*
    한 번에 객체를 매핑하기 위한 매핑 메소드
    ItemDuplicateErrorViewRequest 에 필요한 정보들을 받아서 매핑해준다
    */
    public static ItemDuplicateErrorViewRequest from(int duplicateId){
        return new ItemDuplicateErrorViewRequest(duplicateId);
    }
}