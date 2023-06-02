package view.output;

import dto.request.view.output.ResultViewRequest;

public class ResultView {                                                       //계산 결과를 알려 주기위한 View
    public void showResult(ResultViewRequest request) {                         //계산 결과를 알려주기 위한 메소드
        System.out.println("-------------------- Result --------------------");
        System.out.println("[ 채워진 아이템 수 ] " + request.getTheNumberOfItemsInTheBackpack()
                + "\n[ 배낭의 현재 무게 ] " + request.getWeightOfBackpack()
                + "\n[ 아이템 가치 ] "+ request.getValue());

    }
}