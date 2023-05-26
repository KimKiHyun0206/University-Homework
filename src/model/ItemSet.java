package model;

import dto.request.view.output.ItemDuplicateErrorViewRequest;
import view.output.ItemDuplicateErrorView;

import java.util.LinkedList;
import java.util.List;

public class ItemSet {
    private List<Item> items = new LinkedList<>();

    public void addItem(Item item) {
        if (items.size() <= 10) {                                                           //물건 수가 10이 넘지 않도록 한다
            if (items.contains(item)) {                                                //중복되는 물건이 없다면 넣어준다
                new ItemDuplicateErrorView().alertDuplicateError(                           //중복되는 물건이 있다면 에러 출력
                        new ItemDuplicateErrorViewRequest(items.size() + 1)
                );
            } else {
                items.add(item);                                              //오류가 없다면 아이템을 넣는다
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