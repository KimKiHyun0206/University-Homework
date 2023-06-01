package view.output;

import dto.request.view.output.error.ItemDuplicateErrorViewRequest;

public class ItemDuplicateErrorView {                                           //Item이 중복 되었음을 알려주기 위한 View
    public void alertDuplicateError(ItemDuplicateErrorViewRequest request) {    //Item이 중복 되었음을 알려주기 위한 메소드
        System.out.println("[ Error ] 아이템 " + request.getDuplicateId() + "번이 다른 아이템과 중복되었습니다");
    }

    public void alertError(String errorMessage){                                //Item이 중복 되었음을 알려주기 위한 메소드
        System.out.println("[ Error ] "+ errorMessage+"이(가) 다른 아이템과 중복되었습니다");
    }
}