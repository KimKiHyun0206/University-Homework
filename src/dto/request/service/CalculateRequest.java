package dto.request.service;

import dto.response.input.BackpackInputResponse;
import dto.response.input.ItemInputResponse;
import model.Backpack;
import model.Item;
import model.ItemSet;

import java.util.List;

public class CalculateRequest {                                     //계산을 하기 위해 요청하는 DTO
    private final ItemSet itemSet;                                  //입력 받은 Item 들에 대한 정보
    private final Backpack backpack;                                //입력 받은 배낭에 대한 정보

    public CalculateRequest(ItemSet itemSet, Backpack backpack) {   //일반적인 생성자
        this.itemSet = itemSet;
        this.backpack = backpack;
    }

    public ItemSet getItemSet() {
        return itemSet;
    }

    public int getItemSetSize(){
        return itemSet.getItemSetSize();
    }

    public int getBackpackSize() {
        return backpack.getSize();
    }

    /*
    한 번에 객체를 매핑하기 위한 매핑 메소드
    CalculateRequest 에 필요한 정보들을 받아서 매핑해준다
    */
    public static CalculateRequest from(ItemInputResponse inputResponse, BackpackInputResponse backpackInputResponse) {
        ItemSet instanceItemSet = new ItemSet();
        List<Item> items = inputResponse.getItems();

        items.forEach(instanceItemSet::addItem);
        Backpack instanceBackpack = new Backpack(backpackInputResponse.getBackpackSize());

        return new CalculateRequest(instanceItemSet, instanceBackpack);
    }
}