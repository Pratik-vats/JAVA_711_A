public class CheckoutRequest {
    String uid;
    String assetId;
    int hoursRequested;

    public CheckoutRequest(String uid, String assetId, int hoursRequested) {
        this.uid = uid;
        this.assetId = assetId;
        this.hoursRequested = hoursRequested;

        if (hoursRequested < 1 || hoursRequested > 6) {
            throw new IllegalArgumentException("Hours must be between 1 and 6.");
        }
    }
}