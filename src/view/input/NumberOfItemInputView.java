package view.input;

import dto.request.view.input.ItemInputRequest;

import java.util.Scanner;

public class NumberOfItemInputView {
    private Scanner scanner = new Scanner(System.in);

    public ItemInputRequest getNumberOfItem() {
        System.out.print("[ System ] 아이템의 수를 입력해주세요  ");
        return new ItemInputRequest(scanner.nextInt());
    }
}