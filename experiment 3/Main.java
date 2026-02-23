import java.util.HashMap;

public class Main {

    public static void main(String[] args) {

        AssetStore store = new AssetStore();

        store.addAsset(new Asset("LAB-101", "HDMI Cable", true, 1));
        store.addAsset(new Asset("LAB-202", "Oscilloscope", true, 3));
        store.addAsset(new Asset("LAB-303", "Ethernet Cable", false, 1));

        HashMap<String, Student> students = new HashMap<>();
        students.put("KRG20281", new Student("KRG20281", "Pratik", 0, 0));
        students.put("ABC12345", new Student("ABC12345", "Ravi", 50, 0));
        students.put("KRG77777", new Student("KRG77777", "Ankit", 0, 2));

        CheckoutService service = new CheckoutService(store, students);

        CheckoutRequest[] requests = {
                new CheckoutRequest("KRG20281", "LAB-101", 4),     // Success
                new CheckoutRequest("KRG20281", "LAB-999", 2),     // Invalid asset
                new CheckoutRequest("ABC12345", "LAB-202", 2)      // Fine policy failure
        };

        for (CheckoutRequest req : requests) {

            try {
                String receipt = service.checkout(req);
                System.out.println("SUCCESS: " + receipt);
            }
            catch (IllegalArgumentException e) {
                System.out.println("Invalid Input: " + e.getMessage());
            }
            catch (NullPointerException e) {
                System.out.println("Not Found: " + e.getMessage());
            }
            catch (SecurityException e) {
                System.out.println("Security Issue: " + e.getMessage());
            }
            catch (IllegalStateException e) {
                System.out.println("Policy Violation: " + e.getMessage());
            }
            finally {
                AuditLogger.log("Attempt finished for UID=" + req.uid +
                        ", asset=" + req.assetId);
            }
        }
    }
}