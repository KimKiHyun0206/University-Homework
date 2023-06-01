package view.input;

import dto.request.view.input.ItemInputRequest;
import dto.request.view.output.error.ItemDuplicateErrorViewRequest;
import dto.response.input.ItemInputResponse;
import model.Item;
import service.SortByWeight;
import view.output.ItemDuplicateErrorView;

import java.util.*;

public class ItemInputView {
    private final Scanner scanner = new Scanner(System.in);

    public ItemInputView() {
        System.out.println("[ System ] 아이템 입력은 띄어쓰기로 해주십시오 ( 무게 가치 )");
    }

    public ItemInputResponse input(ItemInputRequest request) {
        List<Item> result = new LinkedList<>();
        for (int i = 0; i < request.getNumberOfItem(); i++) {
            System.out.print("[ Input ] 아이템의 무게와 가치를 입력하시오  ");
            String[] inputValue = scanner.nextLine().split(" ");

            result.add(
                    new Item(
                            i + 1,
                            Integer.parseInt(inputValue[0]),
                            Integer.parseInt(inputValue[1])
                    )
            );
        }

        isValidateInput(result);

        return ItemInputResponse.from(new SortByWeight().sort(result));
    }

    private void isValidateInput(List<Item> result){
        Set<Item> checkSet = new HashSet<>();

        result.forEach(i ->{
            checkSet.add(i);
        });

        if(checkSet.size() != result.size()){
            new ItemDuplicateErrorView().alertDuplicateError(
                    new ItemDuplicateErrorViewRequest(2)
            );
        }
    }
}
