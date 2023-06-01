package service.validation;

import dto.response.input.ItemInputResponse;
import model.Item;
import view.output.ItemDuplicateErrorView;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ItemDuplicateValidation {
    public void check(ItemInputResponse response){
        List<Item> items = response.getItems();
        Set<Integer> weightCheck = new HashSet<>();
        Set<Integer> valueCheck = new HashSet<>();

        items.forEach(
                item -> {
                    weightCheck.add(item.getWeight());
                    valueCheck.add(item.getValue());
                }
        );

        int itemListSize = items.size();

        if(itemListSize != weightCheck.size()){
            new ItemDuplicateErrorView().alertError("무게");
            System.exit(0);
        }
        if (itemListSize != valueCheck.size()){
            new ItemDuplicateErrorView().alertError("가치");
            System.exit(0);
        }
    }
}
