package model;

import dto.request.view.output.error.ItemDuplicateErrorViewRequest;
import service.validation.ItemDuplicateValidation;
import view.output.ItemDuplicateErrorView;

import java.util.LinkedList;
import java.util.List;

public class ItemSet {                                                                      //Item 들에 대한 정보를 저장하기 위한 Model
    private List<Item> items = new LinkedList<>();                                          //Item 들에 대한 정보를 저장하는 List

    public void addItem(Item item) {
        if (items.size() <= 10) {                                                           //물건 수가 10이 넘지 않도록 한다
            if (items.contains(item)) {                                                     //중복되는 물건이 없다면 넣어준다
                new ItemDuplicateErrorView().alertDuplicateError(                           //중복되는 물건이 있다면 에러 출력
                        ItemDuplicateErrorViewRequest.from(items.size() + 1)
                );
                System.exit(0);                                                       //만약 오류 발생 시 프로그램 종료
            } else {
                items.add(item);                                                            //오류가 없다면 아이템을 넣는다
            }
        }
    }

    public Item getItem(int id) {
        return items.get(id);
    }

    public int getItemSetSize() {
        return items.size();
    }
}