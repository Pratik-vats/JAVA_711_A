public class ValidationUtil {

    public static void validateUid(String uid) {
        if (uid == null || uid.length() < 8 || uid.length() > 12 || uid.contains(" ")) {
            throw new IllegalArgumentException("Invalid UID format.");
        }
    }

    public static void validateAssetId(String assetId) {
        if (assetId == null || !assetId.matches("LAB-\\d+")) {
            throw new IllegalArgumentException("Invalid Asset ID format.");
        }
    }

    public static void validateHours(int hrs) {
        if (hrs < 1 || hrs > 6) {
            throw new IllegalArgumentException("Hours must be 1–6.");
        }
    }
}