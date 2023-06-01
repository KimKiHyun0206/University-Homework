package dto.request.view.input;

public class ItemInputRequest {
    private final int numberOfItem;                 //몇 개의 Item 을 입력 받아야 하는지에 대한 정보

    public ItemInputRequest(int numberOfItem) {
        this.numberOfItem = numberOfItem;
    }

    public int getNumberOfItem() {
        return numberOfItem;
    }

    /*
    한 번에 객체를 매핑하기 위한 매핑 메소드
    ItemInputRequest 에 필요한 정보들을 받아서 매핑해준다
    */
    public static ItemInputRequest from(int numberOfItem){
        return new ItemInputRequest(numberOfItem);
    }
}