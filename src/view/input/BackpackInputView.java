package view.input;

import dto.response.input.BackpackInputResponse;

import java.util.Scanner;

public class BackpackInputView {                                    //배낭에 대한 정보를 입력 받기 위한 View
    private final Scanner scanner = new Scanner(System.in);         //값을 입력 받기 위한 Scanner

    public BackpackInputResponse input() {                          //입력 받기 위한 메소드
        System.out.print("[ System ] 배낭의 크기를 입력해주세요  ");
        int size = scanner.nextInt();

        return BackpackInputResponse.from(size);                    //입력 받은 값을 Response 로 매핑하여 리턴
    }
}