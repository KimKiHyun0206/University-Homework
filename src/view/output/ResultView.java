package view.output;

import dto.request.view.output.ResultViewRequest;

public class ResultView {
    public void showResult(ResultViewRequest request) {
        System.out.println("-------------------- Result --------------------");
        System.out.println("[ 채워진 아이템 수 ] " + request.getTheNumberOfItemsInTheBackpack()
                + "\n[ 배낭의 현재 무게 ] " + request.getWeightOfBackpack()
                + "\n[ 아이템 종류 ] ");
        for (int i = 0; i < request.getItems().size(); i++) {
            System.out.println("- " + request.getItems().get(i).toString());
        }
    }
}