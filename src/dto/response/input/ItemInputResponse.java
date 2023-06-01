package dto.response.input;

import model.Item;

import java.util.List;

public class ItemInputResponse {        //입력 받은 Item 들에 대한 정보를 알리기 위한 Response DTO
    private final List<Item> items;     //입력 받은 Item 들에 대한 정보

    public ItemInputResponse(List<Item> items) {
        this.items = items;

    }

    public List<Item> getItems() {
        return items;
    }

    //testMethod
    private void showItems(){
        System.out.println("[  ITEMS  ]");
        for (Item item : items) {
            System.out.println(item.toString());
        }
    }

    /*
    한 번에 객체를 매핑하기 위한 매핑 메소드
    ItemInputResponse 에 필요한 정보들을 받아서 매핑해준다
    */
    public static ItemInputResponse from(List<Item> items){
        return new ItemInputResponse(items);
    }
}