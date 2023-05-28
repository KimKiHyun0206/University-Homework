package service;

import model.Item;

import java.util.Comparator;
import java.util.List;

public class SortByWeight {
    //내림차순으로 정렬
    public List<Item> sort(List<Item> items) {
        items.sort(Comparator.comparingInt(Item::getWeight).reversed());

        return items;
    }
}