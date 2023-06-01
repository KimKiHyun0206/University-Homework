package view.output;

import dto.request.view.output.ResultViewRequest;

public class ResultView {                                                       //계산 결과를 알려 주기위한 View
    public void showResult(ResultViewRequest request) {                         //계산 결과를 알려주기 위한 메소드
        System.out.println("-------------------- Result --------------------");
        System.out.println("[ 채워진 아이템 수 ] " + request.getTheNumberOfItemsInTheBackpack()
                + "\n[ 배낭의 현재 무게 ] " + request.getWeightOfBackpack()
                + "\n[ 아이템 종류 ] ");
        for (int i = 0; i < request.getItems().size(); i++) {                   //배낭에 넣은 Item들에 대한 정보를 알려주기 위한 for문
            System.out.println("- " + request.getItems().get(i).toString());
        }
    }
}