package view.input;

import dto.response.input.BackpackInputResponse;

import java.util.Scanner;

public class BackpackInputView {
    private final Scanner scanner = new Scanner(System.in);
    public BackpackInputResponse input(){
        System.out.print("[ System ] 배낭의 크기를 입력해주세요  ");
        int size = scanner.nextInt();

        return new BackpackInputResponse(size);
    }
}