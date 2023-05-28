package dto.request.view.output.error;

public class ItemDuplicateErrorViewRequest {
    private final int duplicateId;

    public ItemDuplicateErrorViewRequest(int duplicateId) {
        this.duplicateId = duplicateId;
    }

    public int getDuplicateId() {
        return duplicateId;
    }

    public static ItemDuplicateErrorViewRequest from(int duplicateId){
        return new ItemDuplicateErrorViewRequest(duplicateId);
    }
}