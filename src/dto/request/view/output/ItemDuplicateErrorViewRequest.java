package dto.request.view.output;

public class ItemDuplicateErrorViewRequest {
    private final int duplicateId;

    public ItemDuplicateErrorViewRequest(int duplicateId) {
        this.duplicateId = duplicateId;
    }

    public int getDuplicateId() {
        return duplicateId;
    }
}