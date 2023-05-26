package dto.request.service;

import dto.response.input.BackpackInputResponse;
import dto.response.input.ItemInputResponse;
import model.Backpack;
import model.Item;
import model.ItemSet;

import java.util.List;

public class CalculateRequest {
    private final ItemSet itemSet;
    private final Backpack backpack;

    public CalculateRequest(ItemSet itemSet, Backpack backpack) {
        this.itemSet = itemSet;
        this.backpack = backpack;
    }

    public ItemSet getItemSet() {
        return itemSet;
    }

    public int getBackpackSize() {
        return backpack.getSize();
    }

    public static CalculateRequest from(ItemInputResponse inputResponse, BackpackInputResponse backpackInputResponse){
        ItemSet instanceItemSet = new ItemSet();
        List<Item> items = inputResponse.getItems();

        items.forEach(instanceItemSet::addItem);
        Backpack instanceBackpack = new Backpack(backpackInputResponse.getBackpackSize());

        return new CalculateRequest(instanceItemSet, instanceBackpack);
    }
}