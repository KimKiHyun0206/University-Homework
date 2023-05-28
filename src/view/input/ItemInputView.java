package view.input;

import dto.request.view.input.ItemInputRequest;
import dto.response.input.ItemInputResponse;
import model.Item;
import service.SortByWeight;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ItemInputView {
    private final Scanner scanner = new Scanner(System.in);
    private List<Item> result = new LinkedList<>();

    public ItemInputView() {
        System.out.println("[ System ] 아이템 입력은 띄어쓰기로 해주십시오 ( 무게 가치 )");
    }

    public ItemInputResponse input(ItemInputRequest request) {

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


        return ItemInputResponse.from(new SortByWeight().sort(result));
    }
}
