package dto.request.view.output.error;

public class ItemWeightErrorViewRequest {   //Item 의 무게가 잘못 되었음을 알리기 위한 DTO
    private final int weight;               //잘못된 무게 값

    public ItemWeightErrorViewRequest(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    /*
    한 번에 객체를 매핑하기 위한 매핑 메소드
    ItemWeightErrorViewRequest 에 필요한 정보들을 받아서 매핑해준다
    */
    public static ItemWeightErrorViewRequest from(int weight){
        return new ItemWeightErrorViewRequest(weight);
    }
}