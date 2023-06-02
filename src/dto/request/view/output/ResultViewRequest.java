package dto.request.view.output;

import dto.response.service.CalculateResponse;
import model.Item;

import java.util.List;

public class ResultViewRequest {                            //결과를 보여주기 위해 요청하는 DTO
    private final int theNumberOfItemsInTheBackpack;        //배낭에 채워진 아이템의 수
    private final int weightOfBackpack;                     //배낭의 현재 무게
    private final int value;                                //배낭의 담긴 물건의 가치

    public ResultViewRequest(int theNumberOfItemsInTheBackpack, int weightOfBackpack, int value) {
        this.theNumberOfItemsInTheBackpack = theNumberOfItemsInTheBackpack;
        this.weightOfBackpack = weightOfBackpack;
        this.value = value;
    }

    public int getTheNumberOfItemsInTheBackpack() {
        return theNumberOfItemsInTheBackpack;
    }

    public int getWeightOfBackpack() {
        return weightOfBackpack;
    }

    public int getValue() {
        return value;
    }

    /*
        한 번에 객체를 매핑하기 위한 매핑 메소드
        ResultViewRequest 에 필요한 정보들을 받아서 매핑해준다
        */
    public static ResultViewRequest from(CalculateResponse response) {
        return new ResultViewRequest(
                response.getNumberOfItem(),
                response.getWeight(),
                response.getValue()
        );
    }
}