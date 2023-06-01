package service;

import model.Item;

import java.util.Comparator;
import java.util.List;

public class WeightSortService {                         //정렬을 해주는 Service
    public List<Item> sort(List<Item> items) {      //내림 차순으로 정렬해주는 메소드
        items.sort(Comparator.comparingInt(Item::getWeight).reversed());

        return items;
    }
}