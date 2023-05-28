package dto.response.input;

import model.Item;

import java.util.List;

public class ItemInputResponse {
    private final List<Item> items;

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

    public static ItemInputResponse from(List<Item> items){
        return new ItemInputResponse(items);
    }
}