package model;

import java.util.LinkedList;
import java.util.List;

public class CalculateResult {
    private final List<Item> items = new LinkedList<>();
    private int value = 0;
    private int numberOfItem = 0;

    public void addItem(Item item, int size) {
        if (!items.contains(item) && getWeight() + item.getWeight() <= size) {
            items.add(item);
            value += item.getValue();
            numberOfItem = items.size();
        }
    }

    public int getWeight() {
        int sum = 0;

        for (Item item : items) {
            sum += item.getWeight();
        }

        return sum;
    }

    public int getValue() {
        return value;
    }

    public List<Item> getItems() {
        return items;
    }

    public int getNumberOfItem() {
        return numberOfItem;
    }
}