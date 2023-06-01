package view.output;

import dto.request.view.output.error.ItemDuplicateErrorViewRequest;

public class ItemDuplicateErrorView {
    public void alertDuplicateError(ItemDuplicateErrorViewRequest request) {
        System.out.println("[ Error ] 아이템 " + request.getDuplicateId() + "번이 다른 아이템과 중복되었습니다");
        System.exit(0);
    }

    public void alertError(String errorMessage){
        System.out.println("[ Error ] "+ errorMessage+"이(가) 다른 아이템과 중복되었습니다");
    }
}