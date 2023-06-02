package view.input;

import dto.request.view.input.ItemInputRequest;
import dto.request.view.output.error.ItemDuplicateErrorViewRequest;
import dto.response.input.ItemInputResponse;
import model.Item;
import service.WeightSortService;
import view.output.ItemDuplicateErrorView;

import java.util.*;

public class ItemInputView {                                                        //Item 에 대한 정보를 입력 받기 위한 View
    private final Scanner scanner = new Scanner(System.in);                         //값을 입력 받기 위한 Scanner

    public ItemInputResponse input(ItemInputRequest request) {                      //값을 입력 받기 위한 메소드
        System.out.println("[ System ] 아이템 입력은 띄어쓰기로 해주십시오 ( 무게 가치 )"); //입력 형식을 알려준다
        List<Item> result = new LinkedList<>();                                     //결과를 저장하기 위한 List 자료구조
        for (int i = 0; i < request.getNumberOfItem(); i++) {                       //request.getNumberOfItem 만큼 입력 받는다
            System.out.print("[ Input ] 아이템의 무게와 가치를 입력하시오  ");            //입력이 준비됨을 알림
            String[] inputValue = scanner.nextLine().split(" ");              //띄어쓰기로 문자열을 분해함

            result.add(                                                             //result 에 Item 을 넣는다
                    new Item(                                                       //inputValue 를 바탕으로 새로운 Item 생성
                            Integer.parseInt(inputValue[0]),
                            Integer.parseInt(inputValue[1])
                    )
            );
        }

        return ItemInputResponse.from(new WeightSortService().sort(result));        //리턴하기 전에 정렬하여 리턴
    }
}