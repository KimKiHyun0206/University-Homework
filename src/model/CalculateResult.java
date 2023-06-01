package model;

import java.util.LinkedList;
import java.util.List;

public class CalculateResult {                              //계산 결과에 대한 Model
    private final List<Item> items = new LinkedList<>();    //계산 결과 배낭에 담긴 Item
    private int value = 0;                                  //배낭에 담긴 item 들의 가치
    private int numberOfItem = 0;                           //배낭에 담긴 item 들의 갯수

    public void addItem(Item item, int size) {              //배낭에 item 을 더해주는 메소드
        //배낭에 item 이 없고 무게가 배낭 크기를 넘지 않으면 배낭에 담는다
        if (!items.contains(item) && getAllItemsWeight() + item.getWeight() <= size) {
            items.add(item);
            value += item.getValue();                       //배낭에 담긴 item 의 가치를 새로 넣은 item 의 가치만큼 더한다
            numberOfItem = items.size();                    //배낭에 item 이 담겼으니 배낭에 담긴 item 의 갯수를 갱신한다
        }
    }

    public int getAllItemsWeight() {                                //배낭에 담긴 모든 item 의 무게를 합해서 리턴한다
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