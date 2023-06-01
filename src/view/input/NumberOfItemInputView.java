package view.input;

import dto.request.view.input.ItemInputRequest;

import java.util.Scanner;

public class NumberOfItemInputView {                            //몇 개의 Item을 입력 받아야 하는지 입력 받기 위한 View
    private Scanner scanner = new Scanner(System.in);           //입력 받기 위한 Scanner 객체

    public ItemInputRequest getNumberOfItem() {                 //몇 개의 Item을 입력 받아야 하는지 입력 받기 위한 메소드
        System.out.print("[ System ] 아이템의 수를 입력해주세요  ");
        return ItemInputRequest.from(scanner.nextInt());
    }
}