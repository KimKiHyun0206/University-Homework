package view.input;

import dto.request.view.input.ItemInputRequest;
import dto.response.input.ItemInputResponse;
import dto.response.input.NumberOfItemResponse;

import java.util.Scanner;

public class NumberOfItemInputView {                            //몇 개의 Item을 입력 받아야 하는지 입력 받기 위한 View
    private final Scanner scanner = new Scanner(System.in);           //입력 받기 위한 Scanner 객체

    public NumberOfItemResponse getNumberOfItem() {                 //몇 개의 Item을 입력 받아야 하는지 입력 받기 위한 메소드
        System.out.print("[ System ] 아이템의 수를 입력해주세요( 최대 10 ) ");
        while (true){
            int value = scanner.nextInt();
            if(value <= 10){
                return new NumberOfItemResponse(value);
            }else {
                System.out.println("[ Error ] 다시 입력해주세요 ");
            }
        }
    }
}