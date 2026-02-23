import java.time.LocalDate;

public class CheckoutService {

    private AssetStore store;
    private java.util.HashMap<String, Student> students;

    public CheckoutService(AssetStore store, java.util.HashMap<String, Student> students) {
        this.store = store;
        this.students = students;
    }

    public String checkout(CheckoutRequest req)
            throws IllegalArgumentException, IllegalStateException,
                   SecurityException, NullPointerException {

        ValidationUtil.validateUid(req.uid);
        ValidationUtil.validateAssetId(req.assetId);
        ValidationUtil.validateHours(req.hoursRequested);

        Student student = students.get(req.uid);
        if (student == null) {
            throw new NullPointerException("Student not found.");
        }

        Asset asset = store.findAsset(req.assetId);

        student.validatePolicy();
        asset.validatePolicy(req.uid);

        int hours = req.hoursRequested;

        if (hours == 6) {
            System.out.println("Note: Max duration selected. Return strictly on time.");
        }

        if (asset.assetName.contains("Cable") && hours > 3) {
            hours = 3;
            System.out.println("Policy applied: Cables can be issued max 3 hours. Updated to 3.");
        }

        store.markBorrowed(asset);
        student.incrementBorrowCount();

        return "TXN-" + LocalDate.now().toString().replace("-", "") +
                "-" + asset.assetId + "-" + student.uid;
    }
}